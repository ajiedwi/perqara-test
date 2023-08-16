package com.ajiedwi.data.games.implementation.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ajiedwi.data.games.implementation.local.dao.GameDao
import com.ajiedwi.data.games.implementation.local.entities.GameEntity

@Database(entities = [GameEntity::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}