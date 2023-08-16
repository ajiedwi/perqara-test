package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import com.ajiedwi.data.games.implementation.remote.response.GameResponse

fun GameResponse.toModel() = Game(
    id = id ?: 0,
    name = name ?: "",
    released = released ?: "",
    backgroundImage = backgroundImage ?: "",
    rating = rating ?: 0.0,
    playtime = playtime ?: 0,
)

fun Game.toEntity() = GameEntity(
    id = id,
    name = name,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    playtime = playtime,
)

fun GameEntity.toModel() = Game(
    id = id,
    name = name,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    playtime = playtime,
)