package com.shalom.marvelogy.di

import com.google.gson.Gson
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
    fun provideMarvelRepository(gson: Gson): MarvelRepository {
        return MarvelRepositoryImpl(gson)
    }

}