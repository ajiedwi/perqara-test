package com.ajiedwi.data.games.implementation.remote.response

import org.junit.Test

class GameListResponseTest {

    private val game = GameResponse(
        id = 1,
        name = "name of the games",
        released = "release date",
        backgroundImage = "background of the image",
        rating = 4.7,
        playtime = 645,
    )

    @Test
    fun `test getter`(){
        val gameList = GameListResponse(
            results = listOf(game),
            next = "not null"
        )
        assert(gameList.results == listOf(game))
        assert(gameList.next == "not null")
    }

}