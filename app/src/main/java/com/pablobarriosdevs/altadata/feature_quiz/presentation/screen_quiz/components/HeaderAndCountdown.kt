package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablobarriosdevs.altadata.feature_quiz.core.formatTime
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.QuizViewModel

@Composable
fun HeaderAndCountdown(
    viewModel: QuizViewModel,

) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Pregunta  ${viewModel.questionNumber.value}/10"
        )
        Text(
            text = "Puntaje: ${viewModel.score.value}"
        )

    }

    Spacer(modifier = Modifier.height(30.dp))

    Text(
        text = viewModel.timerState.value.formatTime(),
        fontSize = 30.sp
    )
    Spacer(modifier = Modifier.height(30.dp))
}