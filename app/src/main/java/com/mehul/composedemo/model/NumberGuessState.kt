package com.mehul.composedemo.model

data class NumberGuessState(
    val number: String = "",
    val guessText: String? = "",
    val isGuessCorrect: Boolean = false
)
