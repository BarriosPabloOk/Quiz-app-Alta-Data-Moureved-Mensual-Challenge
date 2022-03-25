package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util.PlayerEvent

@Composable
fun PlayerScreen(
    navController: NavController,
    viewModel: PlayerViewModel = hiltViewModel(),
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "DEJÁ TU MARCA")

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = viewModel.playerName.value ?: "",
            onValueChange = { viewModel.onEvent(PlayerEvent.EnterName(it)) },
            placeholder = { Text(text = "Ingresá tu nombre") }
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Tu puntaje fue de ${viewModel.playerScore.value} puntos")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            viewModel.onEvent(PlayerEvent.SavePlayerInLocalSource)
            //navigate
            navController.navigate(Screens.RankingScreen.route)
        }) {

            Text(text = "GUARDAR DATOS")

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //navigate
            navController.navigate(Screens.RankingScreen.route)
        }) {

            Text(text = "OMITIR")

        }

    }

}