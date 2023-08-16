package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.response.GameDetailResponse
import com.ajiedwi.data.games.implementation.remote.response.GameResponse
import org.junit.Test

class GameDetailMapperTest {

    @Test
    fun `test GameDetailResponseDeveloperToModel()`(){
        val developerResponse = GameDetailResponse.Developer(name = "dev 1")
        val developer = developerResponse.toModel()

        assert(developer == GameDetail.Developer(name = "dev 1"))
    }

    @Test
    fun `test GameDetailResponseToModel()`(){
        val gameResponse = GameDetailResponse(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
            developers = listOf(GameDetailResponse.Developer(name = "dev 1"))
        )

        val game = gameResponse.toModel()

        assert(game.id == 1)
        assert(game.name == "name of the games")
        assert(game.released == "release date")
        assert(game.backgroundImage == "background of the image")
        assert(game.rating == 4.7)
        assert(game.playtime == 645)
        assert(game.developers == listOf(GameDetail.Developer("dev 1")))
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

    @Test
    fun `test GameDetailToEntity()`(){
        val gameDetail = GameDetail(
            id = 1,
            name = "name of the games",
            released = "release date",
            backgroundImage = "background of the image",
            rating = 4.7,
            playtime = 645,
        )

        val gameEntity = gameDetail.toGameEntity()

        assert(gameEntity.id == 1)
        assert(gameEntity.name == "name of the games")
        assert(gameEntity.released == "release date")
        assert(gameEntity.backgroundImage == "background of the image")
        assert(gameEntity.rating == 4.7)
        assert(gameEntity.playtime == 645)
    }
}