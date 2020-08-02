package com.shalom.marvelogy.ui.marvelmainfragment.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shalom.marvelogy.repos.marvelrepository.MarvelRepository

class MarvelMainViewModel
@ViewModelInject constructor(
    val marvelRepo: MarvelRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
}