package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.response.GameResponse
import org.junit.Test

class GameMapperTest {

    @Test
    fun `test GameResponseToModel()`(){
        val gameResponse = GameResponse(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
        )

        val game = gameResponse.toModel()

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
    }

    @Test
    fun `test GameEntityToModel()`(){
        val gameEntity = GameEntity(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
        )

        val game = gameEntity.toModel()

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
    }
}