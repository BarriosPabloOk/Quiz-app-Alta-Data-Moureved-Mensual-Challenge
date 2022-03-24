package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper

import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetPlayerWithHighScoreUC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.GetSingleQuestionUC
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.SaveNewPlayerUC

data class UseCases(
    val getPlayers: GetPlayerWithHighScoreUC,
    val getSingleQuestion: GetSingleQuestionUC,
    val saveNewPlayer: SaveNewPlayerUC,
)
