package com.ajiedwi.data.games.implementation.remote.response

import com.google.gson.annotations.SerializedName

data class GameListResponse(
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("results")
    val results: List<GameResponse>? = null,
)
