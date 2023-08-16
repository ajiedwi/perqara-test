package com.ajiedwi.perqaratest.pages.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajiedwi.core.network.TOKEN
import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.api.model.GameList

import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GamesRepository,
) : ViewModel() {

    var gamesListRequest = GamesListRequest(
        apiKey = TOKEN,
    )
    private val _gameListFlow = MutableSharedFlow<GameList>()
    val gameListFlow = _gameListFlow.asSharedFlow()

    private val _favouritesFlow = MutableSharedFlow<List<Game>>()
    val favouritesFlow = _favouritesFlow.asSharedFlow()

    private val _isLoadingFlow = MutableSharedFlow<Boolean>()
    val isLoadingFlow = _isLoadingFlow.asSharedFlow()

    fun fetchGameList(){
        viewModelScope.launch {
            _isLoadingFlow.emit(true)
            repository.fetchGames(gamesListRequest).collect{
                _isLoadingFlow.emit(false)
                _gameListFlow.emit(it)
            }
        }
    }

    fun getFavouriteGames(){
        viewModelScope.launch {
            repository.getFavouriteGames().collect{
                _favouritesFlow.emit(it)
            }
        }
    }

}