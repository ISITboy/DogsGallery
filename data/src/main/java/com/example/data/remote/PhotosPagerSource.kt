package com.example.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.Constant.MAX_COUNT_PHOTOS
import com.example.domain.model.Photo

class PhotosPagerSource(
    private val photosAPI: DogsPhotosAPI
):PagingSource<Int, String>() {
    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    private var totalPhotosCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val page = params.key ?: 1
        return try {
            val photosResponse = photosAPI.getRandomPhotos(page)
            totalPhotosCount += photosResponse.message.size
            val photos = photosResponse.message.distinct()
            Log.d("MyLog","totalPhotosCount $totalPhotosCount")

            LoadResult.Page(
                data = photos,
                nextKey = if (totalPhotosCount == MAX_COUNT_PHOTOS) null else page + 1,
                prevKey = if(page == 1) null else page -1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("MyLog","Exception $e")
            LoadResult.Error(
                throwable = e
            )
        }
    }
}