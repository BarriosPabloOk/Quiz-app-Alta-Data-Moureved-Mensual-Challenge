package com.pablobarriosdevs.altadata.feature_quiz.data.provider

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz


class QuizProvider {

    companion object {

        fun randomQuiz(): Quiz {
            val shuffle = quizList.shuffled()
            val result = shuffle[-1]
            return result
        }

        val quizList = listOf(
            Quiz(
                question = "¿En qué año llegó el hombre a la Luna?",
                answer1 = "1971",
                answer2 = "1953",
                correctAnswer = "1969"
            ),
            Quiz(
                question = "¿Con qué nombre firmaba Van Gogh sus obras?",
                answer1 = "Andrew",
                answer2 = "Lucas",
                correctAnswer = "Vincent"
            ),
            Quiz(
                question = "¿Quién escribió “La Guerra de los Mundos”?",
                answer1 = "Egard A. Poe",
                answer2 = "Julio Verne",
                correctAnswer = "H.G. Wells"
            ),
            Quiz(
                question = "¿Cuál fue la primera película de Disney?",
                answer1 = "La Cenicienta",
                answer2 = "La Sirenita",
                correctAnswer = "Blancanieves"
            ),
            Quiz(
                question = "¿Cómo se llamaba Muhammad Ali antes de adoptar este nombre?",
                answer1 = "Jonh Doe",
                answer2 = "Jimmy Neutron",
                correctAnswer = "Cassius Clay"
            ),
            Quiz(
                question = "¿Cómo se llamaba el ciclista italiano apodado “il campionissimo”?",
                answer1 = "Brais Moure",
                answer2 = "Sergio Mattarella",
                correctAnswer = "Fausto Coppi"
            ),
            Quiz(
                question = "¿De qué país se independizó Eslovenia?",
                answer1 = "Rumania",
                answer2 = "Austria",
                correctAnswer = "Yugoslavia"
            ),
            Quiz(
                question = "¿Qué presidente de la Unión Soviética instauró la Perestroika?",
                answer1 = "Yuri Andrópov ",
                answer2 = "Konstantín Chernenko",
                correctAnswer = "Mijaíl Gorbachov"
            ),
            Quiz(
                question = "¿Qué carabela no regresó del primer viaje de Colón a Las Américas?",
                answer1 = "La Niña",
                answer2 = "La Pinta",
                correctAnswer = "La Santa María"
            ),
            Quiz(
                question = "¿Cuál es el país del mundo con mayor población?",
                answer1 = "Mongolia",
                answer2 = "India",
                correctAnswer = "China"
            )
        )
    }
}