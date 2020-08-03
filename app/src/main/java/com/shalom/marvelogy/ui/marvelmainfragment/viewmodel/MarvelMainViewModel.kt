package com.shalom.marvelogy.ui.marvelmainfragment.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.shalom.marvelogy.repos.marvelrepository.MarvelRepository
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainStateEvent
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainStateEvent.GetCharacters
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainStateEvent.None
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainViewState
import com.shalom.marvelogy.utils.reactiveutils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MarvelMainViewModel
@ViewModelInject constructor(
    private val marvelRepo: MarvelRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()
    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _dataState: MutableLiveData<DataState<MainViewState>> = MutableLiveData()

    val dataState = _dataState as LiveData<DataState<MainViewState>>

    val viewState: LiveData<MainViewState>
        get() = _viewState


    fun updateStateEvent(event: MainStateEvent) {
        _stateEvent.value = event
        handleStateEvent(event)
    }


    private fun handleStateEvent(stateEvent: MainStateEvent) {
        when (stateEvent) {
            is GetCharacters -> {
                viewModelScope.launch {
                    marvelRepo.getCharacters()
                        .flowOn(Dispatchers.Main)
                        .collect {
                            it.data?.let { data ->
                                _viewState.value = data
                            }
                            _dataState.value = it
                        }
                }
            }
            is None -> {

            }
        }
    }


}
