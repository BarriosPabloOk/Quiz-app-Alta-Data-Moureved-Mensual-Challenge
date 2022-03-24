package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util

sealed class QuizEvent{
    data class Answer(val answer :String) : QuizEvent()
    object NextQuestion : QuizEvent()
}
