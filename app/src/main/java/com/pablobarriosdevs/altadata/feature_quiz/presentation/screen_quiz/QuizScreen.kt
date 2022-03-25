package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.R
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.core.formatTime
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizEvent

@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = hiltViewModel(),
    Background : @Composable () -> Unit,
) {

    Background()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.surface)
                .padding(20.dp)

        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Pregunta ${viewModel.questionNumber.value}/10"
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

                Text(
                    text = "Literatura",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "¿Cuál era el tipo de libro que escribía María Elena Walsh?",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.height(30.dp))

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(viewModel.answerList.value) { answer->
                        OutlinedButton(
                            onClick = { viewModel.onEvent(QuizEvent.Answer(answer))},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(width = 1.dp, color = Color.DarkGray),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.DarkGray,
                                backgroundColor = Color.Transparent
                            )
                        ) {
                            Text(text = answer)
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    if (viewModel.questionNumber.value <= 10 && !viewModel.finishedRound.value){
                        Button(
                            onClick = { viewModel.onEvent(QuizEvent.NextQuestion) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                backgroundColor = colorResource(id = R.color.main_background)
                            ),
                            enabled = viewModel.showDialog.value
                        ) {
                            Text(text = "Siguiente pregunta")
                        }
                    }

                    if (viewModel.finishedRound.value){
                        Button(
                            onClick = { navController.navigate(Screens.PlayerScreen.route
                                    + "?${Constants.GET_PLAYER_SCORE}=${Constants.GET_PLAYER_SCORE}"){
//                                popUpTo(navController.graph.startDestinationRoute ?: ""){
//                                    inclusive = true
//                                }
                            }},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                backgroundColor = colorResource(id = R.color.main_background)
                            ),
                            enabled = viewModel.showDialog.value
                        ) {
                            Text(text = "Continuar")
                        }
                    }
                }

            }
        }
    }


}

//@Preview(showSystemUi = true, device = Devices.PIXEL_4)
//@Composable
//fun PrevQuizScreen() {
//    QuizScreen()
//}