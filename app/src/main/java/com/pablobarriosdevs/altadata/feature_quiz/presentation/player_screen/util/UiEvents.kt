package com.pablobarriosdevs.altadata.feature_quiz.presentation.player_screen.util

sealed class UiEvents {
    object SavePlayer:UiEvents()
    data class  ShowSnackBar(val message:String) : UiEvents()
}
