package com.example.dogsphotos.presentation.details

import com.example.domain.model.Photo


sealed class DetailsEvent {
    data class UpsertDeleteArticle(val photo: Photo) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}