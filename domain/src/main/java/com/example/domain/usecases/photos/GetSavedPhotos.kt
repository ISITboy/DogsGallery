package com.example.domain.usecases.photos

import com.example.domain.manger.PhotosDogDao
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedPhotos @Inject constructor(
    private val photosRepository: PhotosRepository
) {

    operator fun invoke(): Flow<List<Photo>> {
        return photosRepository.getSavedPhotos()
    }
}