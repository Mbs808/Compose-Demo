package com.mehul.composedemo.basic_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {


//    Row(
//        modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Start
//    ) {
//
//        Text(
//            text = "Hello Sarvaiya",
//            fontSize = 30.sp,
//            modifier = Modifier.width(130.dp)
//        )
//
//        Column(
//            modifier = Modifier.weight(1f),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.Start
//        ) {
//            Text(
//                text = "Mehul",
//                fontSize = 30.sp
//            )
//        }

//        Spacer(modifier = Modifier.size(10.dp))
//
//        Box(modifier = Modifier
//            .size(100.dp)
//            .background(Color.Red)
//        )
//
//        Spacer(modifier = Modifier.size(10.dp))
//
//        Box(modifier = Modifier
//            .size(100.dp)
//            .background(Color.Green))
//        Spacer(modifier = Modifier.size(10.dp))
//
//        Box(modifier = Modifier
//            .size(100.dp)
//            .background(Color.Black))
//        Spacer(modifier = Modifier.size(10.dp))

//    }

    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
            ) {

        Box(modifier = Modifier.size(100.dp)
            .background(Color.Blue)) { }

        Spacer(modifier = Modifier.size(10.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            Box(modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .background(Color.Red)) { }

            Spacer(modifier = Modifier.size(10.dp))

            Box(modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .background(Color.Green)) { }
        }



    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
fun RowColumnDemoPreview() {
    MyComposeDemoTheme {
        RowColumnDemo()
    }
}