package com.example.dogsphotos.presentation.bookmark

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.dogsphotos.R
import com.example.dogsphotos.presentation.Dimens.MediumPadding1
import com.example.dogsphotos.presentation.common.PhotosList
import com.example.domain.model.Photo

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Photo) -> Unit
) {
    Log.d("MyLog","BookmarkScreen")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ) {


        PhotosList(
            photos = state.photos,
            onClick = navigateToDetails
        )
    }
}