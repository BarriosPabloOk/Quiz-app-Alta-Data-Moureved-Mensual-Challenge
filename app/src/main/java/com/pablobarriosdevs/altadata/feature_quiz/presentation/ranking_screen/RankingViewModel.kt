package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

//Compose states
    private val _score = mutableStateOf<Int>(0)
    val score : State<Int> = _score

    private val _questionNumber = mutableStateOf<Int>(1)
    val questionNumber : State<Int> = _questionNumber

    private val _currentTime = mutableStateOf<Long>(30000L)
    val currentTime : State<Long> = _currentTime

    private val _quizState = mutableStateOf<QuizState>(QuizState())
    val quizState : State<QuizState> = _quizState

//timer object
    val timer = object : CountDownTimer(currentTime.value, 1000){
        override fun onTick(p0: Long) {
            TODO("Not yet implemented")
        }

        override fun onFinish() {
            TODO("Not yet implemented")
        }
    }.start()

    fun stopTimer()= timer.cancel()

}










