package com.pablobarriosdevs.altadata.feature_quiz.domain.model

import com.pablobarriosdevs.altadata.feature_quiz.data.model.QuizData

data class Quiz(
    val question: String,
    val answer1: String,
    val answer2: String,
    val correctAnswer: String,
)

