package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper

import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetPlayerWithHighScore_UC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetSingleQuestion_UC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.SaveNewPlayer_UC

data class UseCases(
    val getPlayers: GetPlayerWithHighScore_UC,
    val getSingleQuestion: GetSingleQuestion_UC,
    val saveNewPlayer: SaveNewPlayer_UC,
)
