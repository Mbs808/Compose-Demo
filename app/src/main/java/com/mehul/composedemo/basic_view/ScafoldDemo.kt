@file:OptIn(ExperimentalMaterial3Api::class)

package com.mehul.composedemo.basic_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun ScafoldDemo(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Hello ")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = {},
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },

        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite"
                        )
                    },
                    label = {
                        Text("Favorite")
                    }
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier=Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {

            Text(
                text = "Hello World",
                color = Color.Red
            )
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun ScafoldPreview() {

    MyComposeDemoTheme {
        ScafoldDemo()
    }
}