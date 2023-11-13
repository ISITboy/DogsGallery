package com.example.data.remote.dto

import com.example.domain.model.Photo

data class DogsPhotosResponse(
    val message: List<String>,
    val status: String
)