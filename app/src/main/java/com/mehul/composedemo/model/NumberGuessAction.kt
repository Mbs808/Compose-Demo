package com.mehul.composedemo.model

sealed interface NumberGuessAction {

    data object OnGuessClick : NumberGuessAction
    data class OnNumberChange(val number: String) : NumberGuessAction
    data object OnStartGameButton : NumberGuessAction
}