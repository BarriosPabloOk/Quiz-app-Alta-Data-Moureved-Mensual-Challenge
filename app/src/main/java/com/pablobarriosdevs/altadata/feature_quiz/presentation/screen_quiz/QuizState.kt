package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

data class QuizState(
    val category:String = "",
    val question:String = "",
    val answers: List<String> = listOf()
)
