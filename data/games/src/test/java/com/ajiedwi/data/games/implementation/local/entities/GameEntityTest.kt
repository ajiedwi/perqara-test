package com.ajiedwi.data.games.implementation.local.entities

import org.junit.Test

class GameEntityTest {

    @Test
    fun `test getter`(){
        val game = GameEntity(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
        )

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
    }

}