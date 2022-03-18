package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen

data class QuizState(
    val category:String = "",
    val question:String = "",
    val answers: List<String> = listOf()
)
