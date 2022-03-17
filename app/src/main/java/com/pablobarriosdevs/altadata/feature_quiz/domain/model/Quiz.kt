package com.pablobarriosdevs.altadata.feature_quiz.domain.model


data class Quiz(
    val question: String,
    val category: String,
    val answer1: String,
    val answer2: String,
    val correctAnswer: String,
)

