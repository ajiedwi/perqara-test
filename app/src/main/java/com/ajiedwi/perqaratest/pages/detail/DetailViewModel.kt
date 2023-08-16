package com.ajiedwi.perqaratest.pages.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.BuildConfig
import com.ajiedwi.core.network.TOKEN
import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.model.GameList

import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.mapper.toGameEntity
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: GamesRepository,
) : ViewModel() {

    var gameDetail = GameDetail()
    private val _gameDetailFlow = MutableSharedFlow<GameDetail>()
    val gameDetailFlow = _gameDetailFlow.asSharedFlow()

    var isFavourite = false
    private val _isFavouriteFlow = MutableSharedFlow<Boolean>()
    val isFavouriteFlow = _isFavouriteFlow.asSharedFlow()

    fun fetchGameDetail(gameId: Int){
        viewModelScope.launch {
            repository.fetchGameDetail(apiKey = TOKEN, gameId = gameId).collect{
                gameDetail = it
                _gameDetailFlow.emit(it)
            }
        }
    }

    fun checkIsFavourite(gameId: Int){
        viewModelScope.launch {
            repository.getFavouriteGameById(id = gameId).collect{
                isFavourite = it.id == gameId
                _isFavouriteFlow.emit(isFavourite)
            }
        }
    }

    fun addToFavourite(){
        viewModelScope.launch {
            repository.addFavouriteGame(gameDetail.toGameEntity()).collect{
                checkIsFavourite(gameId = gameDetail.id)
            }
        }
    }

    fun removeFromFavourite(){
        viewModelScope.launch {
            repository.removeFavouriteGameById(gameDetail.id).collect{
                checkIsFavourite(gameId = gameDetail.id)
            }
        }
    }

}