package com.mehul.composedemo.basic_view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

@Composable
fun Counter(modifier: Modifier = Modifier) {

    var count by remember {
        mutableIntStateOf(0)
    }
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
    )
    {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Count: $count",
                color = Color.Red,
                fontSize = 17.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            Button(modifier = Modifier.padding(top = 10.dp),
                onClick = {
                    if (count < 100) {
                        count++
                    } else {
                        Toast.makeText(context, "Count limit reached (100)", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(text = "Count Add")
            }

            Button(
                onClick = {
                    if (count > 0){
                        count--
                    }else{
                        Toast.makeText(context, "Count cannot be negative", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(text = "Count Remove")
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun CounterPreview(modifier: Modifier = Modifier) {

    MyComposeDemoTheme {
        Counter()
    }
}
