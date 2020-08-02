package com.shalom.marvelogy.repos.marvelrepository

import com.shalom.marvelogy.api.marvelapiservice.MarvelApiService

class MarvelRepositoryImpl constructor(private val marvelApi: MarvelApiService) : MarvelRepository {
    override suspend fun getCharacters(limit: Int) {
        try {
            val chars = marvelApi.getCharacters()
            print(chars)
        } catch (ex: Exception) {
            print(ex)
        }

    }

}