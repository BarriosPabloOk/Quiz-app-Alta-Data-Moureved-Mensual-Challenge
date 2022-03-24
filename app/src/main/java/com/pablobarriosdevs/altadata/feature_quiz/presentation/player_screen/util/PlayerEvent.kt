package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util

sealed class PlayerEvent {
    data class EnterName(val name: String) : PlayerEvent()
    object SavePlayerInLocalSource : PlayerEvent()
}
