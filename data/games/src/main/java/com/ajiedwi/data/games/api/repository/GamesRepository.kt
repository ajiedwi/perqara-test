package com.ajiedwi.data.games.api.repository

import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.model.GameList
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import kotlinx.coroutines.flow.Flow

interface GamesRepository {

    /** fetch games list from API Service **/
    suspend fun fetchGames(request: GamesListRequest): Flow<GameList>

    /** fetch game detail from API Service **/
    suspend fun fetchGameDetail(apiKey: String, gameId: Int): Flow<GameDetail>

}