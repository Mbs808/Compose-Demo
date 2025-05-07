package com.mehul.composedemo.modifir

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun OffsetDemo(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
private fun OffsetDemoPreview() {
    MyComposeDemoTheme {
        OffsetDemo()
    }
}