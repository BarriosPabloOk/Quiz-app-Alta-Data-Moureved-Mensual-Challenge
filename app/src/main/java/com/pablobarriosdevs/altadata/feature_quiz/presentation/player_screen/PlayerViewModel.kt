package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.altadata.feature_quiz.core.Constants
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util.PlayerEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {


    private val _playerScore = mutableStateOf<Int?>(null)
    val playerScore : State<Int?> = _playerScore

    private val _playerName = mutableStateOf<String?>(null)
    val playerName : State<String?> = _playerName



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
                    useCases.saveNewPlayer(
                        Player(
                            name = _playerName.value ?: "Crack sin nombre",
                            score = _playerScore.value ?: 0
                        )
                    )
                }
            }
        }
    }




}