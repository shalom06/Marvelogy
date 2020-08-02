package com.shalom.marvelogy.ui.marvelmainfragment.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shalom.marvelogy.repos.marvelrepository.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarvelMainViewModel
@ViewModelInject constructor(
    private val marvelRepo: MarvelRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            marvelRepo.getCharacters(2)
        }


    }
}