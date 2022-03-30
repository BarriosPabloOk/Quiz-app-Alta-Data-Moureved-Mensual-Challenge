package com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pablobarriosdevs.altadata.R
import com.pablobarriosdevs.altadata.feature_quiz.core.AlternativeBackground

import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.core.MainBackground
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.PlayerScreen
import com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen.RankingScreen
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.HomeScreen
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.QuizScreen

@Composable
fun Navigation(
    navController: NavHostController
) {


    NavHost(navController = navController,
    startDestination = Screens.HomeScreen.route){
        composable(route = Screens.HomeScreen.route){

            HomeScreen(navController){ MainBackground()}
        }
        composable(route = Screens.QuizScreen.route){

            QuizScreen(navController = navController){ AlternativeBackground(alpha = 0.5f)}
        }
        composable(route= Screens.PlayerScreen.route
                +"?${Constants.GET_PLAYER_SCORE}={${Constants.GET_PLAYER_SCORE}}"){

            PlayerScreen(navController){ AlternativeBackground(alpha = 0.5f)}
        }
        composable(route = Screens.RankingScreen.route){

            RankingScreen(navController,){MainBackground(alpha = 0.5f)}
        }

    }

}