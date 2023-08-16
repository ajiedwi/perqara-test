package com.ajiedwi.data.games.implementation.remote.request

data class GamesListRequest(
    var page: Int = 1,
    var pageSize: Int = 10,
    var apiKey: String = "",
    var keyword: String = "",
) {

    fun toQuery(): HashMap<String, Any>{
        val query = HashMap<String, Any>()
        query["page_size"] = pageSize
        query["page"] = page
        if (apiKey.isNotEmpty()) query["key"] = apiKey
        if (keyword.isNotEmpty()) query["search"] = keyword
        return query
    }
}
