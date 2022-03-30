package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState


/*
This Use case is not provided for AppModule.kt
*/
class CustomTimerUS(
    var timerState: MutableState<Long>,
    val interval: Long = 1000L,
    val onFinishedTime : () ->Unit,
) {
    private lateinit var timer: CountDownTimer

    var timerInitialValue = timerState.value

    fun startTimer() {

        timer = object : CountDownTimer(timerState.value, interval) {

            override fun onTick(p0: Long) {
                timerState.value = p0

            }

            override fun onFinish() {
                onFinishedTime()
            }
        }.start()
    }

    fun pauseTimer() {
        timer.cancel()
    }



    fun resetTimer() {
        timerState.value = timerInitialValue
    }


}