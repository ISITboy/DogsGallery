package com.example.domain.usecases.photos

import com.example.domain.manger.PhotosDogDao
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import javax.inject.Inject

class GetSavedPhoto @Inject constructor(
    private val photosRepository: PhotosRepository
) {

    suspend operator fun invoke(url: String):Photo?{
        return photosRepository.getSavedPhoto(url = url)
    }
}