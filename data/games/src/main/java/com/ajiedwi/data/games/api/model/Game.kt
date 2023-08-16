package com.ajiedwi.data.games.api.model

data class Game(
    var id: Int = 0,
    var name: String = "",
    var released: String = "",
    var backgroundImage: String = "",
    var rating: Double = 0.0,
    var playtime: Int = 0,
)
