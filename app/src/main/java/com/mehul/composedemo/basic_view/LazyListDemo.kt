package com.mehul.composedemo.basic_view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100) { i ->
            Text("Items $i")

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun LazyListDemoPreview() {
    MyComposeDemoTheme {
        LazyListDemo()
    }

}