package com.pablobarriosdevs.altadata.feature_quiz.domain.repository

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz
import dagger.Provides
import kotlinx.coroutines.flow.Flow


interface QuizRepository {


    suspend fun savePlayer(player:Player)

    suspend fun getQuestion() : Quiz?
    fun getPlayers() : Flow<List<Player>>

}