package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pablobarriosdevs.altadata.feature_quiz.core.formatTime
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.AnswerType
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizEvent

@Composable
fun QuizScreen(
    //navController: NavController,
    viewModel: QuizViewModel = hiltViewModel()
) {



    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = viewModel.timerState.value.formatTime()
        )

        Text(text = "Puntos: ${viewModel.score.value}")

        Text(text = "categoría: ${viewModel.quizState.value.category}")

        Text(text = "Pregunta: ${viewModel.questionNumber.value}/10")

        Text(text = viewModel.quizState.value.question)

        LazyColumn(modifier = 
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
            items(viewModel.answerList.value){ answer->
                
                Button(onClick = { viewModel.onEvent(QuizEvent.Answer(answer))
                }) {
                    Text(text = answer)
                }
                Spacer(modifier = Modifier.height(10.dp))
                
            }
        }

        if (viewModel.showDialog.value){
            Button(onClick = { viewModel.onEvent(QuizEvent.NextQuestion)
            }) {
                Text(text = viewModel.dialogState.value.title)
            }
        }

    }

}