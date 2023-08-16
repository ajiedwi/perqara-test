package com.ajiedwi.data.games.implementation.repository

import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.model.GameList
import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.local.dao.GameDao
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.mapper.toModel
import com.ajiedwi.data.games.implementation.remote.api.GameApi
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GameRepositoryImpl(
    private val api: GameApi,
    private val gameDao: GameDao,
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

    override suspend fun getFavouriteGames(): Flow<List<Game>> = flow {
        try {
            val result = gameDao.getAll()
            emit(result.map { it.toModel() })
        }
        catch (e: Exception){
            emit(listOf())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getFavouriteGameById(id: Int): Flow<Game> = flow {
        try {
            val result = gameDao.getGameById(id = id)
            emit(result.toModel())
        }
        catch (e: Exception){
            emit(Game())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun addFavouriteGame(entity: GameEntity): Flow<Boolean> = flow {
        try {
            gameDao.insertAll(entity)
            emit(true)
        }
        catch (e: Exception){
            emit(false)
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun removeFavouriteGameById(id: Int): Flow<Boolean> = flow {
        val result = gameDao.deleteGameById(id = id)
        emit(result==1)
    }.flowOn(Dispatchers.IO)
}