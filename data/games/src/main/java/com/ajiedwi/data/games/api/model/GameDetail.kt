package com.ajiedwi.data.games.api.model

data class GameDetail(
    var id: Int = 0,
    var name: String = "",
    var released: String = "",
    var backgroundImage: String = "",
    var rating: Double = 0.0,
    var playtime: Int = 0,
    var description: String = "",
    var developers: List<Developer> = listOf(),
) {

    data class Developer(
        var name: String = "",
    )

}
