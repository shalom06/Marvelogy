package com.shalom.marvelogy.repos.marvelrepository

import com.google.gson.Gson
import javax.inject.Inject

class MarvelRepositoryImpl  constructor(gson: Gson) : MarvelRepository {
    override fun test(): String = "test"
}