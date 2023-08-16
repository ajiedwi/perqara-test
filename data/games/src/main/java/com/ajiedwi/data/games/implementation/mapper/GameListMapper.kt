package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.api.model.GameList
import com.ajiedwi.data.games.implementation.remote.response.GameListResponse

fun GameListResponse.toModel() = GameList(
    results = results?.map { it.toModel() } ?: listOf(),
    isLast = next.isNullOrEmpty(),
)