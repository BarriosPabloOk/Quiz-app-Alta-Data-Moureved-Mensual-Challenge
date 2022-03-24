package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Screens
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components.StartButton

@Composable
fun RankingScreen(
    navController: NavController,
    viewModel: RankingViewModel = hiltViewModel()
) {



        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { Text(text = "Mejores puntuaciones") }
            items(viewModel.playerList.value) { player->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = player.name)
                    Text(text = player.score.toString())

                }
            }
            item {
                StartButton(
                onClick = { navController.navigate(Screens.HomeScreen.route) },
                modifier = Modifier.width(210.dp)
            ) }
        }




}