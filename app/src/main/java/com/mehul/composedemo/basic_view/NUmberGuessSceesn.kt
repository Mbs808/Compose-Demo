package com.mehul.composedemo.basic_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mehul.composedemo.model.NumberGuessAction
import com.mehul.composedemo.model.NumberGuessState
import com.mehul.composedemo.model.NumberGuessViewModel
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    NumberGuessScreen(
        state = state,
        onAction = viewModel::onAction,
        modifier = modifier)
}

@Composable
fun NumberGuessScreen(
    state: NumberGuessState,
    onAction: (NumberGuessAction) -> Unit,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {

        TextField(
            value = state.number,
            onValueChange = { newText ->
                onAction(NumberGuessAction.OnNumberChange(newText))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                onAction(NumberGuessAction.OnGuessClick)
            }
        ) {
            Text(text = "Make Guess")
        }

        if (state.guessText != null) {
            Text(
                text = state.guessText
            )
        }

        if (state.isGuessCorrect) {
            Button(
                onClick = {
                    onAction(NumberGuessAction.OnStartGameButton)
                }
            ) {
                Text(
                    text = "Start Again"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    MyComposeDemoTheme {
        NumberGuessScreen(
            state = NumberGuessState(),
            onAction = {}
        )
    }
}