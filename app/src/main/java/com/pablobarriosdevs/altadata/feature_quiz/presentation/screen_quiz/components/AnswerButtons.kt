package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.QuizViewModel
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.AnswerType
import com.pablobarriosdevs.altadata.ui.theme.Success
import com.pablobarriosdevs.altadata.ui.theme.Wrong
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AnswerButtons(
    viewModel: QuizViewModel,
    onClickedAnswer: (answerPressed: String) -> Unit,

    ) {

    val answerList = viewModel.answerList.value
    var correctAnswer = viewModel.quizState.value.answers[Constants.CORRECT_ANSWER]
    val coroutine = rememberCoroutineScope()


    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(answerList) { answer ->

            //this state are handled here because the buttons need a different state each ones.
            //So items() create three different states
            val backgroundButton = remember { mutableStateOf(Color.Black) }

            OutlinedButton(
                onClick = {
                    onClickedAnswer(answer)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 3.dp, backgroundButton.value),
                colors = ButtonDefaults.buttonColors(
                    contentColor = backgroundButton.value,
                    backgroundColor = Color.Transparent
                ),
            ) {
                Text(
                    text = answer,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            }
            Spacer(modifier = Modifier.height(20.dp))



            //this coroutine allows you to listen to the answerEvent of the QuizViewModel
            coroutine.launch {
                viewModel.answerFlow.collectLatest {
                    when(it){
                        AnswerType.CORRECT -> {
                            if (answer == correctAnswer){backgroundButton.value= Success}
                            else {backgroundButton.value= Color.Black}
                        }
                        AnswerType.WRONG -> {
                            when {
                                answer != correctAnswer -> {backgroundButton.value= Wrong}
                                answer == correctAnswer -> {backgroundButton.value= Success}
                            }
                        }
                        null -> backgroundButton.value = Color.Black
                    }
                }
            }

        }
    }

    Spacer(modifier = Modifier.height(40.dp))
}

