package com.example.data.remote.dto

import com.example.domain.model.Message

data class ListBreedsDogsResponse(
    val message: Message,
    val status: String
)