package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Message
import com.example.domain.model.Photo
import com.example.domain.usecases.breedsDogs.GetBreedsDogs
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhoto(): Flow<PagingData<String>>

    suspend fun getListBreedsDogs():Message

    fun getSelectedDogs(breedsDogs: String):Flow<PagingData<String>>

    suspend fun getSavedPhoto(url:String):Photo?

    suspend fun deleteSavedPhoto(photo: Photo)

    suspend fun insertPhoto(photo: Photo)

    fun getSavedPhotos(): Flow<List<Photo>>

}