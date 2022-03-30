package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.feature_quiz.core.MainBackground
import com.pablobarriosdevs.altadata.feature_quiz.core.StartEndButton
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen.components.ItemRanking
import com.pablobarriosdevs.altadata.ui.theme.AltaDataTheme


@Composable
fun RankingScreen(
    navController: NavController,
    viewModel: RankingViewModel = hiltViewModel(),
    Background: @Composable () -> Unit,
) {

    Background()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,

        ) {
            item { Text(
                text = "Mejores puntuaciones",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Black
            )
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(viewModel.playerList.value) { player->
                ItemRanking(name = player.name, score = player.score)
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))

                StartEndButton(
                onClick = {
                    navController.navigate(Screens.HomeScreen.route)
                          },
                    text = "inicio",
                modifier = Modifier.width(250.dp)
            ) }
        }




}
//
//@Preview(showSystemUi = true)
//@Composable
//fun PrevRankingScreen() {
//    AltaDataTheme {
//        RankingScreen()
//    }
//}