package com.ajiedwi.data.games.di.module

import android.content.Context
import androidx.room.Room
import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.local.DATABASE_NAME
import com.ajiedwi.data.games.implementation.local.database.GameDatabase
import com.ajiedwi.data.games.implementation.remote.api.GameApi
import com.ajiedwi.data.games.implementation.repository.GameRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Provides
    @Singleton
    fun provideGameApi(
        retrofit: Retrofit,
    ): GameApi = retrofit.create(GameApi::class.java)

    @Provides
    @Singleton
    fun provideGameRepository(
        api: GameApi,
        gameDatabase: GameDatabase,
    ): GamesRepository = GameRepositoryImpl(api = api, gameDao = gameDatabase.gameDao())

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        GameDatabase::class.java,
        DATABASE_NAME,
    ).build()

}