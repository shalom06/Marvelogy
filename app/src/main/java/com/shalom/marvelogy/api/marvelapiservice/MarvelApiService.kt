package com.shalom.marvelogy.api.marvelapiservice

import com.shalom.marvelogy.models.network.CharectersApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getCharacters(
    ): CharectersApiResponse
}