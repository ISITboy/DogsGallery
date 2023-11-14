package com.example.dogsphotos.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.dogsphotos.presentation.Dimens.ExtraSmallPadding2
import com.example.dogsphotos.presentation.Dimens.MediumPadding1
import com.example.domain.model.Photo

@Composable
fun PhotosList(
    modifier: Modifier = Modifier,
    photos: List<Photo>,
    onClick: (Photo) -> Unit
) {
    if (photos.isEmpty()){
        Text(text="Not Photo")
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding2)
    ) {
        items(
            count = photos.size,
        ) {
            photos[it]?.let { photo ->
                PhotoCard(photo = photo.urlToImage,modifier = modifier, onClick = { onClick(Photo(photo.urlToImage)) })
            }
        }
    }

}

@Composable
fun PhotosList(
    modifier: Modifier = Modifier,
    photos: LazyPagingItems<String>,
    onClick: (String) -> Unit
) {

    val handlePagingResult = handlePagingResult(photos)


    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(
                count = photos.itemCount,
            ) {
                photos[it]?.let { photo ->
                    PhotoCard(photo = photo,modifier=modifier, onClick = { onClick(photo) })
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(photos: LazyPagingItems<String>): Boolean {
    val loadState = photos.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            Text(text="Not Photo")
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            PhotosShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}