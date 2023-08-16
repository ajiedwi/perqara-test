package com.ajiedwi.data.games.di.module

import com.ajiedwi.data.games.api.repository.GamesRepository
import com.ajiedwi.data.games.implementation.remote.api.GameApi
import com.ajiedwi.data.games.implementation.repository.GameRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    ): GamesRepository = GameRepositoryImpl(api = api)

}