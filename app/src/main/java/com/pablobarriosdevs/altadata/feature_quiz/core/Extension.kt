package com.pablobarriosdevs.altadata.feature_quiz.core

import java.util.concurrent.TimeUnit

private const val time_format = "%02d:%02d"


//convert time to milli seconds
fun Long.formatTime(): String = String.format(
    time_format,
    TimeUnit.MILLISECONDS.toMinutes(this),
    TimeUnit.MILLISECONDS.toSeconds(this) % 60
)