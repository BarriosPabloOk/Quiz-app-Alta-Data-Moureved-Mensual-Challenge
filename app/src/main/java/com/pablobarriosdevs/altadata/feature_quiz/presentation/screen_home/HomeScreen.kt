package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pablobarriosdevs.altadata.feature_quiz.core.MainBackground
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components.RankingButton
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components.StartButton

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    Background: @Composable () -> Unit
) {

    Background()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ALTA\nDATA",
            fontSize = 50.sp,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Italic,
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

        ) {

        //to be replaced with a logo


        Spacer(modifier = Modifier.height(180.dp))

        StartButton(
            onClick = {
                navController.navigate(Screens.QuizScreen.route)
            },
            modifier = Modifier.width(210.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        RankingButton(onClick = {
            navController.navigate(Screens.RankingScreen.route)
        })
        Spacer(modifier = Modifier.height(50.dp))

    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
fun PrevHomeScreen() {
    HomeScreen(
        navController = rememberNavController()
    ) { MainBackground() }
}