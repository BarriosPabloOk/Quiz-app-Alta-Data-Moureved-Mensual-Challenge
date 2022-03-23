package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.CustomTimer
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    //Compose states quiz
    private val _score = mutableStateOf<Int>(0)
    val score : State<Int> = _score

    private val _questionNumber = mutableStateOf<Int>(1)
    val questionNumber : State<Int> = _questionNumber

    private val _quizState = mutableStateOf<QuizState>(QuizState())
    val quizState : State<QuizState> = _quizState


    //Compose states timer
    private val _timerState = mutableStateOf<Long>(30000L)
    val timerState : State<Long> = _timerState

    private val _finished = mutableStateOf<Boolean>(true)
    val finished : State<Boolean> = _finished

    private val _isRunning = mutableStateOf<Boolean>(false)
    val isRunning : State<Boolean> = _isRunning


    //countdown object
    val countDown = CustomTimer(_timerState, 1000L, _finished, _isRunning)


    fun prueba(correctAnswer:Boolean){

    }

}










