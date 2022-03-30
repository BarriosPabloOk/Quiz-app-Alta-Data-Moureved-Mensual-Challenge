package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.core.CustomCard
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components.AnswerButtons
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components.FinishedRound
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components.HeaderAndCountdown
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components.QuestionAndCategory
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizEvent

@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = hiltViewModel(),
    Background: @Composable () -> Unit,
) {

    Background()

    CustomCard {

        if (viewModel.questionNumber.value <= 10 && !viewModel.finishedRound.value) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HeaderAndCountdown(viewModel = viewModel)

                QuestionAndCategory(viewModel = viewModel)

                AnswerButtons(viewModel = viewModel){
                    viewModel.onEvent(QuizEvent.Answer(it))
                }

            }

        }
        if (viewModel.finishedRound.value) {

            FinishedRound(viewModel = viewModel) {

                navController.navigate(
                    Screens.PlayerScreen.route
                            + "?${Constants.GET_PLAYER_SCORE}=${viewModel.score.value}"
                )
            }

        }

    }
}

