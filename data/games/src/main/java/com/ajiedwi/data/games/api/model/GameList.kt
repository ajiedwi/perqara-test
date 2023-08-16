package com.ajiedwi.data.games.api.model

data class GameList(
    var results: List<Game> = listOf(),
    var isLast: Boolean = false,
)
