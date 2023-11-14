package com.example.dogsphotos.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.dogsphotos.R
import com.example.dogsphotos.presentation.Dimens.MediumPadding1
import com.example.dogsphotos.presentation.Dimens.PaddingTopPhotos
import com.example.dogsphotos.presentation.common.PhotosList
import com.example.dogsphotos.presentation.common.SearchBar
import com.example.domain.model.Photo

@Composable
fun HomeScreen(
    photos: LazyPagingItems<String>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (String) -> Unit
) {
    Log.d("MyLog","HomeScreen")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_img),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .width(160.dp)
                .height(60.dp)
                .padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(MediumPadding1))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = navigateToSearch
        )

        PhotosList(
            modifier = Modifier.padding(horizontal = PaddingTopPhotos),
            photos = photos,
            onClick = navigateToDetails
        )
    }
}