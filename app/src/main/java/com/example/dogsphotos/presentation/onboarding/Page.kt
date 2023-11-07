package com.example.dogsphotos.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.dogsphotos.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Funny dogs apps!!!",
        description = "This application will show many funny pictures",
        image = R.drawable.startingimg1
    ),
    Page(
        title = "Select a dog breed",
        description = "Shows pictures of this breed",
        image = R.drawable.startingimg2
    ),
    Page(
        title = "Random picture",
        description = "Will show a lot of funny pictures of random dogs",
        image = R.drawable.startingimg3
    )
)

