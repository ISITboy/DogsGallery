package com.example.dogsphotos.presentation.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsphotos.utils.UIComponent
import com.example.domain.model.Photo
import com.example.domain.usecases.photos.DeletePhotoUseCases
import com.example.domain.usecases.photos.GetSavedPhoto
import com.example.domain.usecases.photos.InsertPhotoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getSavedPhoto: GetSavedPhoto,
    private val deletePhotoUseCases: DeletePhotoUseCases,
    private val insertPhotoUseCases: InsertPhotoUseCases
) : ViewModel() {

    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = getSavedPhoto(url = event.photo.urlToImage)
                    if (article == null){
                        insertPhoto(photo = event.photo)
                    }else{
                        deletePhoto(photo = event.photo)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect ->{
                sideEffect = null
            }
        }
    }

    private suspend fun deletePhoto(photo: Photo) {
        deletePhotoUseCases(photo = photo)
        sideEffect = UIComponent.Toast("Photo deleted")
    }

    private suspend fun insertPhoto(photo: Photo) {
        insertPhotoUseCases(photo = photo)
        sideEffect = UIComponent.Toast("Photo Inserted")
    }

}