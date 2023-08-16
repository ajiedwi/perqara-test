package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.response.GameListResponse
import com.ajiedwi.data.games.implementation.remote.response.GameResponse
import org.junit.Test

class GameListMapperTest {

    @Test
    fun `test GameListResponseToModel()`(){
        val gameResponse = GameResponse(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
        )
        val gameListResponse = GameListResponse(
            results = listOf(gameResponse),
            next = "not null",
        )

        val gameList = gameListResponse.toModel()

        assert(gameList.results == listOf(gameResponse.toModel()))
        assert(!gameList.isLast)
    }

}