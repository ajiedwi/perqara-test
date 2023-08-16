package com.ajiedwi.data.games.api.model

import org.junit.Test

class GameDetailTest {

    @Test
    fun `test getter`(){
        val game = GameDetail(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
            developers = listOf(GameDetail.Developer(name = "dev 1")),
        )

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
        assert(game.developers == listOf(GameDetail.Developer(name = "dev 1")))
    }

    @Test
    fun `test setter`(){
        val game = GameDetail().apply {
            id = 1
            name = "name of the games"
            released = "release date"
            backgroundImage = "background of the image"
            rating = 4.7
            playtime = 645
            developers = listOf(GameDetail.Developer(name = "dev 1"))
        }

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
        assert(game.developers == listOf(GameDetail.Developer(name = "dev 1")))
    }

}