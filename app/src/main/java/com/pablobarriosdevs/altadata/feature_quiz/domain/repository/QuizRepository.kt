package com.pablobarriosdevs.altadata.feature_quiz.domain.repository

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz

interface QuizRepository {

    suspend fun setPlayer(name:String, score: Int)
    suspend fun getQuestion() : Quiz?
    suspend fun getPlayers() : List<Player>?
    suspend fun setPlayer()
}