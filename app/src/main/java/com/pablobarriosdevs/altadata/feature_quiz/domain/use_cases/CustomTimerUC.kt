package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState


/*
All de logic from countdown are moved to this use case
because help to keep clean the viewmodel class
*/
class CustomTimerUC(
    var timerState: MutableState<Long>,
    val interval: Long = 1000L,
    var finished: MutableState<Boolean>,
    var isRunning: MutableState<Boolean>,
) {
    private lateinit var timer: CountDownTimer

    var timerInitialValue = timerState.value

    fun startTimer() {

        timer = object : CountDownTimer(timerState.value, interval) {

            override fun onTick(p0: Long) {
                timerState.value = p0

            }

            override fun onFinish() {
                resetTimer()
            }
        }.start()
        isRunning.value = true
        finished.value = false
    }

    fun pauseTimer() {
        timer.cancel()
        isRunning.value = false
    }

    fun resetTimer() {
        timer.cancel()
        isRunning.value = false
        finished.value = true
        timerState.value = timerInitialValue
    }


}