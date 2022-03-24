package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.altadata.feature_quiz.domain.model.Player
import com.pablobarriosdevs.altadata.feature_quiz.domain.use_cases.wrapper.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {


    private val _playerList = mutableStateOf<List<Player>>(listOf())
    val playerList : State<List<Player>> = _playerList

    var getPlayersJob : Job? = null

    init {
        getPlayers()
    }

    fun getPlayers(){
        getPlayersJob?.cancel()
        getPlayersJob = useCases.getPlayers().onEach {
            _playerList.value = it
        }.launchIn(viewModelScope)
    }
}










