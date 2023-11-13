package com.example.domain.usecases.photos

import androidx.paging.PagingData
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class GetPhotos(
    private val photosRepository: PhotosRepository
) {
    operator fun invoke(): Flow<PagingData<String>> {
        return photosRepository.getPhoto()
    }
}