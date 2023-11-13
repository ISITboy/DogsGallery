package com.example.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.remote.DogsPhotosAPI
import com.example.data.remote.PhotosPagerSource
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class PhotosRepositoryImpl(
    private val photosAPI: DogsPhotosAPI
) : PhotosRepository {
    override fun getPhoto(): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory ={
                PhotosPagerSource(photosAPI)
            }
        ).flow
    }
}