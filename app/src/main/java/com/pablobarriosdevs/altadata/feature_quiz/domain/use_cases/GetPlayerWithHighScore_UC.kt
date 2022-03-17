package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetPlayerWithHighScore_UC @Inject constructor(
    private val repository: QuizRepository
) {

    suspend operator fun invoke(): Flow<List<Player>> {
        return repository.getPlayers().map { players ->
            players.sortedByDescending { it.score }.filterIndexed { index, player ->
                index < 10
            }
        }
    }
}
