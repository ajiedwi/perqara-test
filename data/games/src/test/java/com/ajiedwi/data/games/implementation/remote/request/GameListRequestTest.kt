package com.ajiedwi.data.games.implementation.remote.request

import org.junit.Test

class GameListRequestTest {

    @Test
    fun `test getter`(){
        val request = GamesListRequest(
            page = 12,
            pageSize = 45,
            apiKey = "some api key",
            keyword = "some keyword",
        )

        assert(request.page == 12)
        assert(request.pageSize == 45)
        assert(request.apiKey == "some api key")
        assert(request.keyword == "some keyword")

    }

    @Test
    fun `test setter`(){
        val request = GamesListRequest().apply {
            page = 12
            pageSize = 45
            apiKey = "some api key"
            keyword = "some keyword"
        }

        assert(request.page == 12)
        assert(request.pageSize == 45)
        assert(request.apiKey == "some api key")
        assert(request.keyword == "some keyword")

    }

    @Test
    fun `test toQuery`(){
        val request = GamesListRequest().apply {
            page = 12
            pageSize = 45
            apiKey = "some api key"
            keyword = "some keyword"
        }

        val query = request.toQuery()
        assert(query["page"] == 12)
        assert(query["page_size"] == 45)
        assert(query["key"] == "some api key")
        assert(query["search"] == "some keyword")

    }

}