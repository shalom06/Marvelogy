package com.shalom.marvelogy.models.network

import com.shalom.marvelogy.models.network.Items

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<Items>,
    val returned: String
)