package com.shalom.marvelogy.ui.marvelmainfragment.state

import com.shalom.marvelogy.models.network.CharactersApiResponse

data class MainViewState(
    var charactersApiResponse: CharactersApiResponse? = null
)