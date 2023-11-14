package com.example.domain.usecases.breedsDogs

import com.example.domain.model.Message
import com.example.domain.repository.PhotosRepository

class GetBreedsDogs(
    val photosRepository: PhotosRepository
) {
    suspend operator fun invoke(): Message{
        return photosRepository.getListBreedsDogs()
    }

}