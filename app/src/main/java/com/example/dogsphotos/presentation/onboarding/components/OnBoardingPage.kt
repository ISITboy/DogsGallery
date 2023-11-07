package com.example.dogsphotos.presentation.onboarding.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.dogsphotos.R
import com.example.dogsphotos.presentation.Dimens.MediumPadding1
import com.example.dogsphotos.presentation.Dimens.MediumPadding2
import com.example.dogsphotos.presentation.onboarding.Page
import com.example.dogsphotos.ui.theme.DogsPhotosTheme

@SuppressLint("ResourceType")
@Composable
fun OnBoardingPage(
    modifier:Modifier = Modifier,
    page: Page
){
    Column(modifier=modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image),
            contentDescription =null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text=page.title,
            modifier = Modifier.padding(MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.black)
        )
        Text(
            text=page.description,
            modifier = Modifier.padding(MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.black)
        )

    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
    DogsPhotosTheme {
        OnBoardingPage(
            page = Page(
                title = "Funny dogs apps!!!",
                description = "This application will show many funny pictures",
                image = R.drawable.startingimg1
            )
        )
    }
}

