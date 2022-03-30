package com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation

sealed class Screens(val route :String){
    object HomeScreen:Screens("home_screen")
    object QuizScreen:Screens("quiz_screen")
    object PlayerScreen:Screens("player_screen")
    object RankingScreen:Screens("ranking_screen")
}
