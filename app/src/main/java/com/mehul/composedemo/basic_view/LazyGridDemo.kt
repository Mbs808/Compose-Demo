package com.mehul.composedemo.basic_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {

//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(50.dp),
//        verticalArrangement = Arrangement.spacedBy(10.dp),
//        horizontalArrangement = Arrangement.spacedBy(10.dp)
//    ) {
//        items(100) {
//            Box(modifier = Modifier.height(100.dp).
//                width(width = Random.nextInt(1..200).dp)
//                .background(Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))))
//        }
//
//    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(5),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp
    ) {
        items(100) {
            Box(modifier = Modifier
                .height(height = Random.nextInt(1..200).dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))))
        }

    }


}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun GridDemoPreview() {

    MyComposeDemoTheme {
        LazyGridDemo()
    }

}