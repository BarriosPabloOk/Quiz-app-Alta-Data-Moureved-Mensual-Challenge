package com.pablobarriosdevs.altadata.feature_quiz.data.provider

import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Quiz


class QuizProvider {


    fun randomQuiz(): Quiz {
        val shuffle = quizList.shuffled()
        val result = shuffle.random()
        return result
    }

    val quizList = listOf(
        ///Historia
        Quiz(
            question = "¿En qué año llegó el hombre a la Luna?",
            category = "Historia",
            answer1 = "1971",
            answer2 = "1953",
            correctAnswer = "1969"
        ),
        Quiz(
            question = "¿Cómo se llamaba Muhammad Ali antes de adoptar este nombre?",
            category = "Historia",
            answer1 = "Jonh Doe",
            answer2 = "Jimmy Neutron",
            correctAnswer = "Cassius Clay"
        ),
        Quiz(
            question = "¿Cuál fue el primer país en aprobar el sufragio femenino?",
            category = "Historia",
            answer1 = "Alemania",
            answer2 = "Sudáfrica",
            correctAnswer = "Nueva Zelanda"
        ),
        Quiz(
            question = "¿Cuál era la ciudad hogar de Marco Polo?",
            category = "Historia",
            answer1 = "Roma",
            answer2 = "Nápoles",
            correctAnswer = "Venecia"
        ),
        Quiz(
            question = "¿Cuál era la ciudad hogar de Marco Polo?",
            category = "Historia",
            answer1 = "Roma",
            answer2 = "Nápoles",
            correctAnswer = "Venecia"
        ),
        Quiz(
            question = "¿Cómo se llamaba el ciclista italiano apodado “il campionissimo”?",
            category = "Historia",
            answer1 = "Brais Moure",
            answer2 = "Sergio Mattarella",
            correctAnswer = "Fausto Coppi"
        ),
        Quiz(
            question = "¿Qué carabela no regresó del primer viaje de Colón a Las Américas?",
            category = "Historia",
            answer1 = "La Niña",
            answer2 = "La Pinta",
            correctAnswer = "La Santa María"
        ),
        Quiz(
            question = "¿Qué presidente de la Unión Soviética instauró la Perestroika?",
            category = "Historia",
            answer1 = "Yuri Andrópov ",
            answer2 = "Konstantín Chernenko",
            correctAnswer = "Mijaíl Gorbachov"
        ),

        //Arte y literatura
        Quiz(
            question = "¿Con qué nombre firmaba Van Gogh sus obras?",
            category = "Arte",
            answer1 = "Andrew",
            answer2 = "Lucas",
            correctAnswer = "Vincent"
        ),
        Quiz(
            question = "¿Quién escribió “La Guerra de los Mundos”?",
            category = "Literatura",
            answer1 = "Egard A. Poe",
            answer2 = "Julio Verne",
            correctAnswer = "H.G. Wells"
        ),

        //Entretenimiento
        Quiz(
            question = "¿Cuál fue la primera película de Disney?",
            category = "Entretenimiento",
            answer1 = "La Cenicienta",
            answer2 = "La Sirenita",
            correctAnswer = "Blancanieves"
        ),

        //Geografía
        Quiz(
            question = "¿De qué país se independizó Eslovenia?",
            category = "Geografía",
            answer1 = "Rumania",
            answer2 = "Austria",
            correctAnswer = "Yugoslavia"
        ),

        Quiz(
            question = "¿Cuál es la capital de Filipinas?",
            category = "Geografía",
            answer1 = "Bangkok",
            answer2 = "Dheli",
            correctAnswer = "Manila"
        ),
        Quiz(
            question = "¿Qué país está entre Perú y Colombia?",
            category = "Geografía",
            answer1 = "Paraguay",
            answer2 = "Brasil",
            correctAnswer = "Ecuador"
        ),
        Quiz(
            question = "¿A qué país pertenece la isla de Creta?",
            category = "Geografía",
            answer1 = "Macedonia del Norte",
            answer2 = "Turqía",
            correctAnswer = "Grecia"
        ),
        Quiz(
            question = "¿En qué país de Europa se habla el magyar?",
            category = "Geografía",
            answer1 = "Liechtenstein",
            answer2 = "Moldavia",
            correctAnswer = "Hungría"
        ),



    )
}
