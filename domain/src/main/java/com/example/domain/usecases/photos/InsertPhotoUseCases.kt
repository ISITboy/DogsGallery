package com.example.domain.usecases.photos

import com.example.domain.manger.PhotosDogDao
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import javax.inject.Inject

class InsertPhotoUseCases @Inject constructor(
    private val photosRepository: PhotosRepository
) {

    suspend operator fun invoke(photo:Photo){
        photosRepository.insertPhoto(photo = photo)
    }
}