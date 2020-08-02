package com.shalom.marvelogy.repos.marvelrepository

interface MarvelRepository {

    suspend fun getCharacters(limit: Int)
}