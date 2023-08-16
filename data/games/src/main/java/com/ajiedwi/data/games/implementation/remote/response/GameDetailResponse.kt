package com.ajiedwi.data.games.implementation.remote.response

import com.google.gson.annotations.SerializedName

data class GameDetailResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("released")
    var released: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("background_image")
    var backgroundImage: String? = null,
    @SerializedName("rating")
    var rating: Double? = null,
    @SerializedName("playtime")
    var playtime: Int? = null,
    @SerializedName("developers")
    var developers: List<Developer>? = null,
) {

    data class Developer(
        @SerializedName("name")
        val name: String? = null,
    )

}
