package com.ajiedwi.data.games.implementation.mapper

import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.implementation.remote.response.GameResponse

fun GameResponse.toModel() = Game(
    id = id ?: 0,
    name = name ?: "",
    released = released ?: "",
    backgroundImage = backgroundImage ?: "",
    rating = rating ?: 0.0,
    playtime = playtime ?: 0,
)