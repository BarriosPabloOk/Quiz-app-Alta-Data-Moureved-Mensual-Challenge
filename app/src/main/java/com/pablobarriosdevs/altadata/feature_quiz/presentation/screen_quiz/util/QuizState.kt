package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util

data class QuizState(
    val category:String = "",
    val question:String = "",
    val answers: Map<String, String> = mapOf()
)
