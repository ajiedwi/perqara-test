package com.ajiedwi.data.games.implementation.repository

import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.model.GameList
import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.mapper.toModel
import com.ajiedwi.data.games.implementation.remote.api.GameApi
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameRepositoryImpl(
    private val api: GameApi,
) : GamesRepository {
    override suspend fun fetchGames(request: GamesListRequest): Flow<GameList> = flow {
        try {
            val response = api.fetchGames(query = request.toQuery())
            emit(response.toModel())
        }
        catch (e: Exception){
            emit(GameList(isLast = true))
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun fetchGameDetail(apiKey: String, gameId: Int): Flow<GameDetail> = flow {
        try {
            val response = api.fetchGameDetail(key = apiKey, id = gameId.toString())
            emit(response.toModel())
        }
        catch (e: Exception){
            emit(GameDetail())
        }

    }.flowOn(Dispatchers.IO)
}