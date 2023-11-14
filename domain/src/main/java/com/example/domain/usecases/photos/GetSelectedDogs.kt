package com.example.domain.usecases.photos

import androidx.paging.PagingData
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class GetSelectedDogs(
    private val photosRepository: PhotosRepository,
) {
    operator fun invoke(breedsDogs: String): Flow<PagingData<String>> {
        return photosRepository.getSelectedDogs(breedsDogs)
    }
}