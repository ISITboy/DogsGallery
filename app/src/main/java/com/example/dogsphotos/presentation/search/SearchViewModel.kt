package com.example.dogsphotos.presentation.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecases.photos.PhotosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val photosUseCases: PhotosUseCases
) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                Log.d("MyLog","SearchEvent.UpdateSearchQuery")
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchNews -> {
                Log.d("MyLog","SearchEvent.SearchNews")
                searchNews()
            }
        }
    }

    private fun searchNews() {
        val photos =photosUseCases.getSelectedDogs(breedsDogs = _state.value.searchQuery)
            .cachedIn(viewModelScope)
        _state.value = _state.value.copy(breedsDogs = photos)
    }


}