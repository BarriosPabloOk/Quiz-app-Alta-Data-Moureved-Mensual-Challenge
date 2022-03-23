package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pablobarriosdevs.altadata.feature_quiz.core.formatTime

@Composable
fun QuizScreen(
    //navController: NavController,
    viewModel: QuizViewModel = viewModel()
) {

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = viewModel.countDown.timerState.value.formatTime()
        )

        Text(text = "Puntos: ${viewModel.score.value}")

        Text(text = "Pregunta: ${viewModel.questionNumber}/10")

        Button(onClick = { viewModel.prueba(true)}) {
            Text(text = "respuesta correcta")
        }

        Button(onClick = { viewModel.prueba(false)}) {
            Text(text = "respuesta Incorrecta")
        }
    }

}