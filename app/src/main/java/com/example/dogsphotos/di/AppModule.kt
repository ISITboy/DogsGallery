package com.example.dogsphotos.di

import android.app.Application
import com.example.data.manager.LocalUserManagerImpl
import com.example.data.remote.DogsPhotosAPI
import com.example.data.remote.repository.PhotosRepositoryImpl
import com.example.dogsphotos.Constants.BASE_URL
import com.example.domain.repository.PhotosRepository
import com.example.domain.usecases.app_entry.AppEntryUsesCases
import com.example.domain.usecases.app_entry.ReadAppEntry
import com.example.domain.usecases.app_entry.SaveAppEntry
import com.example.domain.usecases.photos.GetPhotos
import com.example.domain.usecases.photos.PhotosUseCases
import com.loc.newsapp.domain.manger.LocalUserManger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManger = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun providesAppEntryUsesCases(
        localUserManager: LocalUserManger
    ) = AppEntryUsesCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
    @Provides
    @Singleton
    fun providePhotosApi():DogsPhotosAPI {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogsPhotosAPI::class.java)
    }
    @Provides
    @Singleton
    fun providePhotosRepository(
        photosAPI: DogsPhotosAPI
    ):PhotosRepository = PhotosRepositoryImpl(photosAPI)

    @Provides
    @Singleton
    fun providePhotosUseCases(
        photosRepository: PhotosRepository
    ):PhotosUseCases{
        return PhotosUseCases(
            getPhotos = GetPhotos(photosRepository)
        )
    }

}