package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import com.pablobarriosdevs.altadata.feature_quiz.domain.util.NamePlayerException
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util.PlayerEvent
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util.UiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {


    private val _playerScore = mutableStateOf<Int>(0)
    val playerScore : State<Int?> = _playerScore

    private val _playerName = mutableStateOf<String>("")
    val playerName : State<String?> = _playerName

    private val _evenFlow = MutableSharedFlow<UiEvents>()
    val eventFlow: SharedFlow<UiEvents> = _evenFlow



    init {
        savedStateHandle.get<String>(Constants.GET_PLAYER_SCORE)?.let {
            _playerScore.value = it.toInt()
        }
    }

    fun onEvent(event:PlayerEvent){
        when(event){

            is PlayerEvent.EnterName -> {
                _playerName.value = event.name
            }

            PlayerEvent.SavePlayerInLocalSource -> {
                viewModelScope.launch {
                    try {
                        useCases.saveNewPlayer(
                            Player(
                                name = _playerName.value ,
                                score = _playerScore.value
                            )
                        )

                        _evenFlow.emit(UiEvents.SavePlayer)

                    } catch (e: NamePlayerException) {
                        _evenFlow.emit(
                            UiEvents.ShowSnackBar(
                                message = e.message ?: "No se pudo guardar el jugador"
                            )
                        )
                    }

                }
            }
        }
    }




}