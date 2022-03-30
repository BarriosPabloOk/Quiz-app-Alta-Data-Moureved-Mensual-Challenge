package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pablobarriosdevs.altadata.feature_quiz.core.AlternativeBackground
import com.pablobarriosdevs.altadata.feature_quiz.core.CustomCard
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util.PlayerEvent
import com.pablobarriosdevs.altadata.ui.theme.AltaDataTheme

@Composable
fun PlayerScreen(
    navController: NavController,
    viewModel: PlayerViewModel = hiltViewModel(),
) {

    AlternativeBackground()
    CustomCard {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "DEJÁ TU MARCA",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = viewModel.playerName.value ?: "",
                onValueChange = { viewModel.onEvent(PlayerEvent.EnterName(it)) },
                placeholder = {
                    Text(
                        text = "Ingresá tu nombre",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Black

                    )
                }
            )
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Tu puntaje fue de: ${viewModel.playerScore.value} puntos",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    viewModel.onEvent(PlayerEvent.SavePlayerInLocalSource)
                    navController.navigate(Screens.RankingScreen.route)
                },
                modifier = Modifier
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ),

                ) {
                Text(
                    text = "Guardar Cambios",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { navController.navigate(Screens.RankingScreen.route) },
                modifier = Modifier
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ),

                ) {
                Text(
                    text = "Omitir",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

        }
    }

}

//@Preview(showSystemUi = true)
//@Composable
//fun PrevPlayerScreen() {
//    AltaDataTheme {
//        PlayerScreen()
//    }
//}