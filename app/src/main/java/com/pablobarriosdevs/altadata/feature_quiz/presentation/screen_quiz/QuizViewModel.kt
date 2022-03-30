package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.CustomTimerUS
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.AnswerType
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizEvent
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    //Compose states quiz
    private val _score = mutableStateOf<Int>(0)
    val score: State<Int> = _score

    private val _questionNumber = mutableStateOf<Int>(1)
    val questionNumber: State<Int> = _questionNumber

    private val _quizState = mutableStateOf<QuizState>(QuizState())
    val quizState: State<QuizState> = _quizState

    private val _answerList = mutableStateOf<List<String>>(listOf())
    val answerList: State<List<String>> = _answerList


    //Correct and Wrong answer. Finished round


    private val _finishedRound = mutableStateOf<Boolean>(false)
    val finishedRound: State<Boolean> = _finishedRound

    //Compose states timer
    private val timerInitialValue = 30000L

    private val _timerState = mutableStateOf<Long>(timerInitialValue)
    val timerState: State<Long> = _timerState

    //Used to emit a event to color buttons state
    private val _answerFlow = MutableSharedFlow<AnswerType?>()
    val answerFlow = _answerFlow.asSharedFlow()


    //countdown object
    private val countDown = CustomTimerUS(_timerState, 1000L) {
        viewModelScope.launch { _answerFlow.emit(AnswerType.WRONG) }
        onEvent(QuizEvent.NextQuestion)
    }


    init {
        viewModelScope.launch {
            countDown.startTimer()
            getQuestion()


        }
    }



    fun onEvent(event: QuizEvent) {
        //called at last quiz


        when (event) {
            is QuizEvent.Answer -> {

                countDown.pauseTimer()

                viewModelScope.launch {
                    if (event.answer == _quizState.value.answers[Constants.CORRECT_ANSWER]) {
                        _score.value += _timerState.value.toInt() / 1000
                        _answerFlow.emit(AnswerType.CORRECT)
                    } else {
                        _answerFlow.emit(AnswerType.WRONG)
                    }
                    onEvent(QuizEvent.NextQuestion)

                }
            }
            QuizEvent.NextQuestion -> {
                viewModelScope.launch {
                    delay(3000)
                    _answerFlow.emit(null)
                    getQuestion()
                    _questionNumber.value++
                    countDown.resetTimer()
                    countDown.startTimer()
                    roundCompleted()
                }

            }
        }

    }

    private fun getQuestion() {

        viewModelScope.launch {
            val getQuestion = useCases.getSingleQuestion().also {
                _quizState.value = quizState.value.copy(
                    category = it?.category ?: "falló la carga de la categoría",
                    question = it?.question ?: "falló la carga de la pregunta",
                    answers = mutableMapOf(
                        "answer1" to (it?.answer1 ?: "no hay nada"),
                        "answer2" to (it?.answer2 ?: "no hay nada"),
                        "correctAnswer" to (it?.correctAnswer ?: "no hay nada")

                    )
                )
                _answerList.value = _quizState.value.answers.values.toList().shuffled()
            }
        }
    }

    private fun roundCompleted() {
        if (_questionNumber.value > 10) {
            _finishedRound.value = true
        }
    }


}










