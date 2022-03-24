package com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz
import com.pablobarriosdevs.altadata.feature_quiz.domain.repository.QuizRepository
import javax.inject.Inject


class GetSingleQuestionUC @Inject constructor(
    private val repository: QuizRepository
) {

    suspend operator fun invoke(): Quiz? {
        return repository.getQuestion()

    }
}