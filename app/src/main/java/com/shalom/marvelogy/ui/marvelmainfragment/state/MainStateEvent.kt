package com.shalom.marvelogy.ui.marvelmainfragment.state

sealed class MainStateEvent {
    object GetCharacters : MainStateEvent()
    object None : MainStateEvent()
}