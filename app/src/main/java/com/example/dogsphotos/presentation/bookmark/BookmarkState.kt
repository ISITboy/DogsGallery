package com.example.dogsphotos.presentation.bookmark

import com.example.domain.model.Photo

data class BookmarkState(
    val photos: List<Photo> = emptyList()
)