package com.ajiedwi.data.games.implementation.remote.response

import org.junit.Test

class GameDetailResponseTest {

    @Test
    fun `test getter`(){
        val game = GameDetailResponse(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
            developers = listOf(GameDetailResponse.Developer(name = "dev 1")),
        )

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
        assert(game.developers == listOf(GameDetailResponse.Developer(name = "dev 1")))
    }

}