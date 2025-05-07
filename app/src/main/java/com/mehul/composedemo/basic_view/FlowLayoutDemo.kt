@file:OptIn(ExperimentalLayoutApi::class)

package com.mehul.composedemo.basic_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun FlowLayout(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) } // State for expand/collapse
    FlowRow(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        maxLines = if (expanded) Int.MAX_VALUE else 2, // Dynamically adjust maxLines
        overflow = if (expanded) FlowRowOverflow.Visible else {
            FlowRowOverflow.expandOrCollapseIndicator(
                expandIndicator = {
                    IconButton(onClick = { expanded = true }) { // Update state on click
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand"
                        )
                    }
                },
                collapseIndicator = {
                    IconButton(onClick = { expanded = false }) { // Update state on click
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Collapse"
                        )
                    }
                }
            )
        }
    ) {
        for (i in 1..20) {
            AssistChip(onClick = { }, label = { Text("Item $i") })
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun FlowLayoutPreview() {

    MyComposeDemoTheme {
        FlowLayout()
    }
}