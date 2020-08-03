package com.shalom.marvelogy.repos.marvelrepository

import com.shalom.marvelogy.ui.marvelmainfragment.state.MainViewState
import com.shalom.marvelogy.utils.reactiveutils.DataState
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    suspend fun getCharacters(): Flow<DataState<MainViewState>>

}