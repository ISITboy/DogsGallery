package com.example.data.remote

import com.example.data.remote.Constant.MAX_COUNT_PHOTOS
import com.example.data.remote.dto.DogsPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DogsPhotosAPI {

    @GET("breeds/image/random/$MAX_COUNT_PHOTOS")
    suspend fun getRandomPhotos(
        @Query("page") page:Int,
    ):DogsPhotosResponse

}