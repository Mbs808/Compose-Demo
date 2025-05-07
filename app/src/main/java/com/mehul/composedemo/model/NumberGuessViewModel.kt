package com.mehul.composedemo.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {

    private var number = Random.nextInt(1, 101)
    private var attempt = 0

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.OnGuessClick -> {

                val guess = state.value.number.toIntOrNull()
                if (guess != null) {
                    attempt++
                }

                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please enter a number"
                            number > guess -> "Number is greater"
                            number < guess -> "Number is smaller"
                            else -> "You guessed it in $attempt attempts"
                        },
                        isGuessCorrect = guess == number,
                        number = "",)
                }
            }

            is NumberGuessAction.OnNumberChange -> {
                    _state.update {
                        it.copy(
                            number = action.number
                        )
                    }
            }

            NumberGuessAction.OnStartGameButton -> {
                number = Random.nextInt(1, 101)
                _state.update {
                    it.copy(
                        guessText = null,
                        isGuessCorrect = false,
                        number = "",

                        )
                }
            }
        }

    }


}