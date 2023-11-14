package com.example.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.manger.PhotosDogDao
import com.example.data.remote.DogsPhotosAPI
import com.example.data.remote.PhotosPagerSource
import com.example.data.remote.PhotosSelectedPagerSource
import com.example.domain.model.Message
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class PhotosRepositoryImpl(
    private val photosAPI: DogsPhotosAPI,
    private val photosDogDao: PhotosDogDao
) : PhotosRepository {
    override fun getPhoto(): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory ={
                PhotosPagerSource(photosAPI)
            }
        ).flow
    }

    override suspend fun getListBreedsDogs(): Message {
        return photosAPI.getBreedsDogs().message
    }

    override fun getSelectedDogs(breedsDogs: String): Flow<PagingData<String>> {
        return return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory ={
                PhotosSelectedPagerSource(photosAPI,breedsDogs)
            }
        ).flow
    }

    override suspend fun getSavedPhoto(url: String): Photo? {
        return photosDogDao.getPhoto(url = url)
    }

    override suspend fun deleteSavedPhoto(photo: Photo) {
        photosDogDao.delete(photo)
    }

    override suspend fun insertPhoto(photo: Photo) {
        photosDogDao.insert(photo)
    }

    override fun getSavedPhotos(): Flow<List<Photo>> {
        return photosDogDao.getPhotos()
    }


}