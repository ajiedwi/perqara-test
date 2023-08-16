package com.ajiedwi.data.games.api.repository

import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.model.GameList
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import kotlinx.coroutines.flow.Flow

interface GamesRepository {

    /** fetch games list from API Service **/
    suspend fun fetchGames(request: GamesListRequest): Flow<GameList>

    /** fetch game detail from API Service **/
    suspend fun fetchGameDetail(apiKey: String, gameId: Int): Flow<GameDetail>

    /** get all favourite games from database **/
    suspend fun getFavouriteGames(): Flow<List<Game>>

    /** get favourite game by id from database **/
    suspend fun getFavouriteGameById(id: Int): Flow<Game>

    /** add favourite game to database **/
    suspend fun addFavouriteGame(entity: GameEntity): Flow<Boolean>

    /** remove favourite game by id from database **/
    suspend fun removeFavouriteGameById(id: Int): Flow<Boolean>

}