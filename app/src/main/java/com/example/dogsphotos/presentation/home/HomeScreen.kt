package com.example.dogsphotos.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.dogsphotos.R
import com.example.dogsphotos.presentation.Dimens.MediumPadding1
import com.example.dogsphotos.presentation.Dimens.PaddingTopPhotos
import com.example.dogsphotos.presentation.common.PhotosList

@Composable
fun HomeScreen(
    photos: LazyPagingItems<String>
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(MediumPadding1))

//        SearchBar(
//            modifier = Modifier
//                .padding(horizontal = MediumPadding1)
//                .fillMaxWidth(),
//            text = "",
//            readOnly = true,
//            onValueChange = {},
//            onSearch = {},
//            onClick = navigateToSearch
//        )

        PhotosList(
            modifier = Modifier.padding(horizontal = PaddingTopPhotos),
            photos = photos
        )
    }
}