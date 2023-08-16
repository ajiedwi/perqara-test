package com.ajiedwi.data.games.implementation.remote.api

import com.ajiedwi.data.games.implementation.remote.response.GameDetailResponse
import com.ajiedwi.data.games.implementation.remote.response.GameListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GameApi {

    @GET("games")
    suspend fun fetchGames(
        @QueryMap query: Map<String, @JvmSuppressWildcards Any>,
    ): GameListResponse

    @GET("games/{id}")
    suspend fun fetchGameDetail(
        @Path("id") id: String,
        @Query("key") key: String,
    ): GameDetailResponse

}