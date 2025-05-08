package com.mehul.composedemo.basic_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme


private val boundedConstraints = Constraints(
    minWidth = 50,
    maxWidth = 100,
    minHeight = 70,
    maxHeight = 150
)

private val unboundedConstraints = Constraints()

private val exactConstraints = Constraints(
    minWidth = 50,
    maxWidth = 50,
    minHeight = 100,
    maxHeight = 100
)

private val combineConstraints = Constraints(
    minWidth = 50,
    maxWidth = 60,
    minHeight = 50,
    maxHeight = Constraints.Infinity
)


@Composable
fun MeasurementDemo(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(10.dp)
    ) {

        Text(
            text = "Hello",
            modifier = Modifier
                .background(Color.Green)
                .padding(start = 10.dp, end = 10.dp)
        )

        Text(
            text = "Mehul",
            color = Color.White,
            modifier = Modifier
                .background(Color.Blue)
                .padding(start = 10.dp, end = 10.dp)


        )
    }
}

@Preview
@Composable
private fun MeasurementDemoPreview() {
    MyComposeDemoTheme {
        MeasurementDemo()
    }
}