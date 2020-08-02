package com.shalom.marvelogy.models.network

data class Items(
    val name: String,
    val resourceURI: String,
    val type: String? = null
)