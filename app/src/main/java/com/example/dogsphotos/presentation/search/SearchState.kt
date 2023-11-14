package com.example.dogsphotos.presentation.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val breedsDogs: Flow<PagingData<String>>? = null
)