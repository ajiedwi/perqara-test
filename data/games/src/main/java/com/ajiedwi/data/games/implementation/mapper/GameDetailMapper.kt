package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.api.model.GameDetail
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.response.GameDetailResponse

fun GameDetailResponse.toModel() = GameDetail(
    id = id ?: 0,
    name = name ?: "",
    released = released ?: "",
    backgroundImage = backgroundImage ?: "",
    rating = rating ?: 0.0,
    playtime = playtime ?: 0,
    description = description?: "",
    developers = developers?.map { it.toModel() } ?: listOf()
)

fun GameDetailResponse.Developer.toModel() = GameDetail.Developer(
    name = name?: "",
)

fun GameDetail.toGameEntity() = GameEntity(
    id = id,
    name = name,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    playtime = playtime,
)