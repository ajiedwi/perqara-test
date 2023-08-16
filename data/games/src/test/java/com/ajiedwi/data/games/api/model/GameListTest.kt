package com.ajiedwi.data.games.api.model

import org.junit.Test

class GameListTest {

    private val game = Game(
        id = 1,
        name = "name of the games",
        released = "release date",
        backgroundImage = "background of the image",
        rating = 4.7,
        playtime = 645,
    )

    @Test
    fun `test getter`(){
        val gameList = GameList(
            results = listOf(game),
            isLast = true,
        )
        assert(gameList.results == listOf(game))
        assert(gameList.isLast)
    }

    @Test
    fun `test setter`(){
        val gameList = GameList().apply {
            results = listOf(game)
            isLast = true
        }
        assert(gameList.results == listOf(game))
        assert(gameList.isLast)
    }

}