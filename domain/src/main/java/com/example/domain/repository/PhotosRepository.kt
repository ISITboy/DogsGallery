package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhoto(): Flow<PagingData<String>>
}