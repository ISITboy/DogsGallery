package com.example.dogsphotos.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecases.photos.GetPhotos
import com.example.domain.usecases.photos.PhotosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photosUseCases: PhotosUseCases
):ViewModel(){
    val news = photosUseCases.getPhotos().cachedIn(viewModelScope)
}