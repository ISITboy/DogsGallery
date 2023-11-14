package com.example.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

class PhotosSelectedPagerSource (
    private val photosAPI: DogsPhotosAPI,
    private val breedDogs:String
):PagingSource<Int, String>() {

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    private var totalPhotosCount = 0
    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, String> {
        val page = params.key ?: 1
        return try {
            val photosResponse = photosAPI.getSelectedPhotoDogs(breedDogs,page)
            totalPhotosCount += photosResponse.message.size
            val photos = photosResponse.message.distinct()
            Log.d("MyLog","totalPhotosCount $totalPhotosCount")

            PagingSource.LoadResult.Page(
                data = photos,
                nextKey = if (totalPhotosCount == Constant.MAX_COUNT_PHOTOS) null else page + 1,
                prevKey = if(page == 1) null else page -1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("MyLog","Exception $e")
            PagingSource.LoadResult.Error(
                throwable = e
            )
        }
    }
}