package com.shalom.marvelogy.repos.marvelrepository

import com.shalom.marvelogy.api.marvelapiservice.MarvelApiService
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainViewState
import com.shalom.marvelogy.utils.reactiveutils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MarvelRepositoryImpl constructor(private val marvelApi: MarvelApiService) : MarvelRepository {
    override suspend fun getCharacters(): Flow<DataState<MainViewState>> = flow {
        emit(DataState.loading(true))
        val chars = marvelApi.getCharacters()
        emit(DataState.data(data = MainViewState(chars)))
    }.catch { ex ->
        emit(DataState.error(message = ex.message.toString()))
    }.flowOn(Dispatchers.IO)
}
