package com.shalom.marvelogy.di

import com.shalom.marvelogy.api.marvelapiservice.MarvelApiService
import com.shalom.marvelogy.repos.marvelrepository.MarvelRepository
import com.shalom.marvelogy.repos.marvelrepository.MarvelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMarvelRepository(marvelApiService: MarvelApiService): MarvelRepository {
        return MarvelRepositoryImpl(marvelApiService)
    }

}