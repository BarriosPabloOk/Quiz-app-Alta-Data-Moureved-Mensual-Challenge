package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import javax.inject.Inject


class SaveNewPlayer_UC @Inject constructor(
    private val repository: QuizRepository
) {

    suspend operator fun invoke(player: Player){
        repository.savePlayer(player)
    }
}