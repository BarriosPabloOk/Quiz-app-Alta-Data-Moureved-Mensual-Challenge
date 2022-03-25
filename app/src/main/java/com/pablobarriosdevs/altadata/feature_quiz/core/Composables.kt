package com.pablobarriosdevs.altadata.feature_quiz.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.pablobarriosdevs.altadata.R


@Composable
fun MainBackground() {
    Image(
        painter = painterResource(id = R.mipmap.background_4),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun AlternativeBackground() {
    Image(
        painter = painterResource(id = R.mipmap.background_3),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
    )
}

