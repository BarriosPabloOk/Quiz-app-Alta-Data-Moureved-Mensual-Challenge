package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pablobarriosdevs.altadata.R
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.QuizViewModel
import com.pablobarriosdevs.altadata.ui.theme.AltaDataTheme

@Composable
fun FinishedRound(
    viewModel: QuizViewModel,
    navigate : ()->Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Hey Crack!!!  Tu puntaje fue de: ",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "${viewModel.score.value} puntos",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = { navigate() },
            modifier = Modifier
                .height(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = MaterialTheme.colors.primaryVariant
            ),

        ) {
            Text(
                text = "Continuar",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.body1.fontSize
            )
        }
    }

}

//@Preview(showSystemUi = true)
//@Composable
//fun PrevFinishedRound() {
//
//    AltaDataTheme {
//        FinishedRound() {
//
//        }
//    }
//}










