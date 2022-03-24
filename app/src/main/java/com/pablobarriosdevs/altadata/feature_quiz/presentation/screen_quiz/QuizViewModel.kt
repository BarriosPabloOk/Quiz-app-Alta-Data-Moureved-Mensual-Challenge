package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.CustomTimerUS
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.DialogState
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizEvent
import com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_quiz.util.QuizState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    //timer object
    private lateinit var timer: CountDownTimer

    //Compose states quiz
    private val _score = mutableStateOf<Int>(0)
    val score: State<Int> = _score

    private val _questionNumber = mutableStateOf<Int>(1)
    val questionNumber: State<Int> = _questionNumber

    private val _quizState = mutableStateOf<QuizState>(QuizState())
    val quizState: State<QuizState> = _quizState

    private val _answerList = mutableStateOf<List<String>>(listOf())
    val answerList : State<List<String>> = _answerList

    //dialog states

    private val _showDialog = mutableStateOf<Boolean>(false)
    val showDialog : State<Boolean> = _showDialog

    private val _dialogState = mutableStateOf<DialogState>(DialogState())
    val dialogState : State<DialogState> = _dialogState

    //Compose states timer
    private val timerInitialValue = 30000L
    private val _timerState = mutableStateOf<Long>(timerInitialValue)
    val timerState: State<Long> = _timerState

    private val _finished = mutableStateOf<Boolean>(true)
    val finished: State<Boolean> = _finished

    private val _isRunning = mutableStateOf<Boolean>(false)
    val isRunning: State<Boolean> = _isRunning


    //countdown object
    val countDown = CustomTimerUS(_timerState, 1000L, _finished, _isRunning) {
        _dialogState.value = dialogState.value.copy(
            title = "Lo sentimos. No hay más tiempo.",
            score = "Puntos acumulados hasta ahora : ${_score.value}"
        )
        _showDialog.value = true
    }


    init {
        viewModelScope.launch {
            delay(2000)
            countDown.startTimer()
            getQuestion()

        }
    }

    fun onEvent(event: QuizEvent){
        when(event){
            is QuizEvent.Answer -> {
                if (event.answer == _quizState.value.answers["correctAnswer"]){

                    _score.value += (_timerState.value/1000).toInt()
                    _dialogState.value = dialogState.value.copy(
                        title = "Felicitaciones",
                        score = "Puntos acumulados hasta ahora : ${_score.value}"
                    )
                    _showDialog.value = true
                    countDown.resetTimer()

                }else{
                    _dialogState.value = dialogState.value.copy(
                        title = "Lo sentimos. Respuesta incorrecta",
                        score = "Puntos acumulados hasta ahora : ${_score.value}"
                    )
                    _showDialog.value = true
                    countDown.resetTimer()
                }
            }
            QuizEvent.NextQuestion -> {
                _questionNumber.value ++
                getQuestion()
                _showDialog.value = false
                countDown.resetTimer()
                countDown.startTimer()
            }
        }
    }

    private fun getQuestion(){

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






}










