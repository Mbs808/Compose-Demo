package com.mehul.composedemo.basic_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mehul.composedemo.R
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .size(200.dp), contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = null
        )

        Text(
            text = "Hello Mehul",
            modifier = Modifier.align(Alignment.Center), color = Color.Red
        )

    }


}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun BoxDemoPreview() {
    MyComposeDemoTheme {
        BoxDemo()
    }
}
