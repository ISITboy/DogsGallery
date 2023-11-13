package com.example.dogsphotos.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.model.Photo
import org.jetbrains.annotations.Async

@Composable
fun PhotoCard(
    modifier: Modifier,
    photo: String,
){
    val context = LocalContext.current

    Row(modifier = modifier.clickable { }){
        AsyncImage(
            modifier = Modifier.fillMaxWidth().height(300.dp).clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(photo).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}