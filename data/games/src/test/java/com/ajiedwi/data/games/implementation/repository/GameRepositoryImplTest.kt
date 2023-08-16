package com.ajiedwi.data.games.implementation.repository

import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.local.dao.GameDao
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.mapper.toModel
import com.ajiedwi.data.games.implementation.remote.api.GameApi
import com.ajiedwi.data.games.implementation.remote.request.GamesListRequest
import com.ajiedwi.data.games.implementation.remote.response.GameDetailResponse
import com.ajiedwi.data.games.implementation.remote.response.GameListResponse
import com.ajiedwi.data.games.implementation.remote.response.GameResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GameRepositoryImplTest {

    private val api: GameApi = mockk(relaxed = true)
    private val dao: GameDao = mockk(relaxed = true)
    private lateinit var repository: GamesRepository
    private val exGameEntity = GameEntity(id = 123)
    private val exGameResponse = GameResponse(id = 123)
    private val exGameDetailResponse = GameDetailResponse(id = 124)
    private val exGameListRequest = GamesListRequest()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        repository = GameRepositoryImpl(api = api, gameDao = dao)
    }

    @Test
    fun `test fetchGames success()`() = runBlocking {
        coEvery { api.fetchGames(query = exGameListRequest.toQuery()) } returns GameListResponse(
            results = listOf(exGameResponse),
            next = "not null",
        )

        val dataToTest = repository.fetchGames(request = exGameListRequest)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(!dataResult.isLast)
        assert(dataResult.results.size == 1)
        assert(dataResult.results[0] == exGameResponse.toModel())
    }

    @Test
    fun `test fetchGames failed()`() = runBlocking {
        coEvery { api.fetchGames(query = exGameListRequest.toQuery()) } throws Exception("some error")

        val dataToTest = repository.fetchGames(request = exGameListRequest)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult.isLast)
        assert(dataResult.results.isEmpty())
    }

    @Test
    fun `test fetchGameDetail success()`() = runBlocking {
        coEvery { api.fetchGameDetail(key = "key", id = "123") } returns exGameDetailResponse

        val dataToTest = repository.fetchGameDetail(apiKey = "key", gameId = 123)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult == exGameDetailResponse.toModel())
    }

    @Test
    fun `test fetchGameDetail failed()`() = runBlocking {
        coEvery { api.fetchGameDetail(key = "key", id = "123") } throws Exception("some error")

        val dataToTest = repository.fetchGameDetail(apiKey = "key", gameId = 123)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult == GameDetail())
    }

    @Test
    fun `test getFavouriteGames success()`() = runBlocking {
        coEvery { dao.getAll() } returns listOf(exGameEntity)

        val dataToTest = repository.getFavouriteGames()
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult == listOf(exGameEntity.toModel()))
    }

    @Test
    fun `test getFavouriteGames failed()`() = runBlocking {
        coEvery { dao.getAll() } throws Exception("some error")

        val dataToTest = repository.getFavouriteGames()
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult.isEmpty())
    }

    @Test
    fun `test getFavouriteGameById success()`() = runBlocking {
        coEvery { dao.getGameById(id = 134) } returns exGameEntity

        val dataToTest = repository.getFavouriteGameById(id = 134)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult == exGameEntity.toModel())
    }

    @Test
    fun `test getFavouriteGameById failed()`() = runBlocking {
        coEvery { dao.getGameById(id = 134) } throws Exception("some error")

        val dataToTest = repository.getFavouriteGameById(id = 134)
        val dataResult = dataToTest.last()

        assert(dataToTest.count() == 1)
        assert(dataResult == Game())
    }

    @Test
    fun `test addFavouriteGame success()`() = runBlocking {
        val dataToTest = repository.addFavouriteGame(exGameEntity)
        val dataResult = dataToTest.last()
        coVerify { dao.insertAll(exGameEntity) }

        assert(dataToTest.count() == 1)
        assert(dataResult)
    }

    @Test
    fun `test addFavouriteGame failed()`() = runBlocking {
        coEvery { dao.insertAll(exGameEntity) } throws Exception("some error")
        val dataToTest = repository.addFavouriteGame(exGameEntity)
        val dataResult = dataToTest.last()
        coVerify { dao.insertAll(exGameEntity) }

        assert(dataToTest.count() == 1)
        assert(!dataResult)
    }

    @Test
    fun `test removeFavouriteGameById()`() = runBlocking {
        coEvery { dao.deleteGameById(id = 194) } returns 1
        val dataToTest = repository.removeFavouriteGameById(id = 194)
        val dataResult = dataToTest.last()
        coVerify { dao.deleteGameById(id = 194) }

        assert(dataToTest.count() == 1)
        assert(dataResult)
    }
}