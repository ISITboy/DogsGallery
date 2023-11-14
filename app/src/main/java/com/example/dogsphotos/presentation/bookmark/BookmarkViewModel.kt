package com.example.dogsphotos.presentation.bookmark

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.photos.GetSavedPhoto
import com.example.domain.usecases.photos.GetSavedPhotos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val getSavedPhotos: GetSavedPhotos
) : ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getSavedPhotos().onEach {
            _state.value = _state.value.copy(photos = it)
        }.launchIn(viewModelScope)
    }
}