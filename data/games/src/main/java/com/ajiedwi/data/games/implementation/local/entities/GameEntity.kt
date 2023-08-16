package com.ajiedwi.data.games.implementation.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ajiedwi.data.games.implementation.local.TABLE_FAVOURITE_GAME_NAME

@Entity(tableName = TABLE_FAVOURITE_GAME_NAME)
data class GameEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "released") val released: String = "",
    @ColumnInfo(name = "backgroundImage") val backgroundImage: String = "",
    @ColumnInfo(name = "rating") val rating: Double = 0.0,
    @ColumnInfo(name = "playtime") val playtime: Int = 0,
)
