package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.QuizViewModel

@Composable
fun QuestionAndCategory(
    viewModel: QuizViewModel,
) {
    Text(
        text = viewModel.quizState.value.category,
        color = Color.Gray
    )
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = viewModel.quizState.value.question,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Black
    )
    Spacer(modifier = Modifier.height(30.dp))
}