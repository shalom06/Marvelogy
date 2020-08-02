package com.shalom.marvelogy.models.network

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<Items>,
    val returned: String
)