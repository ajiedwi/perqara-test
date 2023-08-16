package com.ajiedwi.data.games.implementation.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ajiedwi.data.games.implementation.local.TABLE_FAVOURITE_GAME_NAME
import com.ajiedwi.data.games.implementation.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM $TABLE_FAVOURITE_GAME_NAME")
    suspend fun getAll(): List<GameEntity>

    @Query("SELECT * FROM $TABLE_FAVOURITE_GAME_NAME WHERE id = :id")
    suspend fun getGameById(id: Int): GameEntity

    @Insert
    suspend fun insertAll(vararg recent: GameEntity)

    @Query("DELETE FROM $TABLE_FAVOURITE_GAME_NAME WHERE id = :id")
    suspend fun deleteGameById(id: Int): Int

}