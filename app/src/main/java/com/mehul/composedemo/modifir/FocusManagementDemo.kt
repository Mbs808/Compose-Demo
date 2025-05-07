package com.mehul.composedemo.modifir

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun FocusManagementDemo(modifier: Modifier = Modifier) {

    val focusRequester = remember {
        FocusRequester()
    }

    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = "",
            onValueChange = {},
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = "",
            onValueChange = {},)
        Button(
            onClick = {
                focusRequester.requestFocus()
            }
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusManagementDemoPreview() {
    MyComposeDemoTheme {
        FocusManagementDemo()

    }
}