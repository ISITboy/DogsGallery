package com.example.data.remote

import com.example.data.remote.Constant.MAX_COUNT_PHOTOS
import com.example.data.remote.dto.DogsPhotosResponse
import com.example.data.remote.dto.ListBreedsDogsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogsPhotosAPI {

    @GET("breeds/list/all")
    suspend fun getBreedsDogs():ListBreedsDogsResponse

    @GET("breed/{selectedBreed}/images/random/$MAX_COUNT_PHOTOS")
    suspend fun getSelectedPhotoDogs(
        @Path("selectedBreed") breedDogs:String,
        @Query("page") page:Int
    ):DogsPhotosResponse

    @GET("breeds/image/random/$MAX_COUNT_PHOTOS")
    suspend fun getRandomPhotos(
        @Query("page") page:Int,
    ):DogsPhotosResponse


}