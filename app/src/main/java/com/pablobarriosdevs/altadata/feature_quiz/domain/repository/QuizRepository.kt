package com.pablobarriosdevs.altadata.feature_quiz.domain.repository

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz
import kotlinx.coroutines.flow.Flow


interface QuizRepository {

    suspend fun savePlayer(name:String, score: Int)
    suspend fun getQuestion() : Quiz?
    suspend fun getPlayers() : Flow<List<Player>>

}