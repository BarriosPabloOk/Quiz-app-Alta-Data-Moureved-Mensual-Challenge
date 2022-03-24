package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.R
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components.RankingButton
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components.StartButton

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Image(
        painter = painterResource(id = R.mipmap.background_4),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,

    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

        ) {
        StartButton(
            onClick = { navController.navigate(Screens.QuizScreen.route) },
            modifier = Modifier.width(210.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        RankingButton(onClick = { navController.navigate(Screens.RankingScreen.route)})
        Spacer(modifier = Modifier.height(50.dp))

    }

}

@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
fun PrevHomeScreen() {
    //HomeScreen()
}