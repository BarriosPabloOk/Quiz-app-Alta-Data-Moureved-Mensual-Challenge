package com.pablobarriosdevs.altadata.feature_quiz.data.repoitory

import com.pablobarriosdevs.altadata.feature_quiz.data.local.PlayerDao
import com.pablobarriosdevs.altadata.feature_quiz.data.provider.QuizProvider
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow

class QuizRepositoryImpl(
    private val dao:PlayerDao,
    private val provider: QuizProvider
): QuizRepository {

    override suspend fun savePlayer(player: Player) {
        dao.savePlayer(player)
    }

    override suspend fun getQuestion(): Quiz? {
        return provider.randomQuiz()
    }

    override fun getPlayers(): Flow<List<Player>> {
        return dao.getPlayers()
    }
}