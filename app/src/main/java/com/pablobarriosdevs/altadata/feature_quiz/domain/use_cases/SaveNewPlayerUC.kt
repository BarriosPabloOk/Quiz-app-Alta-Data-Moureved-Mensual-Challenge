package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import com.pablobarriosdevs.altadata.feature_quiz.domain.util.NamePlayerException
import javax.inject.Inject


class SaveNewPlayerUC @Inject constructor(
    private val repository: QuizRepository
) {

    @Throws(NamePlayerException::class)
    suspend operator fun invoke(player: Player){
        if (player.name.isBlank()){
            throw NamePlayerException("El nombre no puede estar vacío")
        }
        return repository.savePlayer(player)
    }
}