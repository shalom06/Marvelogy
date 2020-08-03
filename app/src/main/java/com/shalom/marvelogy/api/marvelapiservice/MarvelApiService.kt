package com.shalom.marvelogy.api.marvelapiservice

import com.shalom.marvelogy.models.network.CharactersApiResponse
import retrofit2.http.GET

interface MarvelApiService {

    @GET("characters")
    suspend fun getCharacters(
    ): CharactersApiResponse
}