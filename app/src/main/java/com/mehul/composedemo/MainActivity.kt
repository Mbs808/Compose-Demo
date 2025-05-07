package com.mehul.composedemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehul.composedemo.basic_view.BoxDemo
import com.mehul.composedemo.basic_view.Counter
import com.mehul.composedemo.basic_view.CustomViewDemo
import com.mehul.composedemo.basic_view.FlowLayout
import com.mehul.composedemo.basic_view.LazyGridDemo
import com.mehul.composedemo.basic_view.LazyListDemo
import com.mehul.composedemo.basic_view.NumberGuessScreenRoot
import com.mehul.composedemo.basic_view.RowColumnDemoPreview
import com.mehul.composedemo.modifir.FocusManagementDemo
import com.mehul.composedemo.modifir.ShapDemo
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeDemoTheme {
                DemoSelector(onBackClick = { finish() })
            }
        }
    }
}

@Composable
fun Greeting(onBackClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 5.dp, end = 5.dp)
            )
        }

        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 21.sp,
            ),
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
        )
    }
}

@Composable
fun DemoSelector(onBackClick: () -> Unit) {
    var selectedDemo by remember { mutableStateOf<String?>(null) }

    // Handle back press in full screen mode
    BackHandler(enabled = selectedDemo != null) {
        selectedDemo = null
    }

    Crossfade(targetState = selectedDemo, modifier = Modifier.fillMaxSize()) { currentDemo ->
        if (currentDemo == null) {
            // Buttons + Initial UI
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.fillMaxSize()) {
                Greeting(onBackClick = onBackClick)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.spacedBy(8.dp)) {

                    Button(onClick = { selectedDemo = "LazyGrid" }) {
                        Text("LazyGridDemo")
                    }

                    Button(onClick = { selectedDemo = "LazyList" }) {
                        Text("LazyListDemo")
                    }
                    Button(onClick = { selectedDemo = "Flow" }) {
                        Text("FlowLayout")
                    }
                    Button(onClick = { selectedDemo = "Box" }) {
                        Text("BoxDemo")
                    }
                    Button(onClick = { selectedDemo = "RowColumn" }) {
                        Text("RowColumnDemo")
                    }
                    Button(onClick = { selectedDemo = "CustomViewDemo" }) {
                        Text("CustomViewDemo")
                    }
                    Button(onClick = { selectedDemo = "Counter" }) {
                        Text("Counter")
                    }
                    Button(onClick = { selectedDemo = "NumberGuessScreenRoot" }) {
                        Text("NumberGuessScreenRoot")
                    }
                    Button(onClick = { selectedDemo = "ShapDemo" }) {
                        Text("ShapDemo")
                    }
                    Button(onClick = { selectedDemo = "FocusManagement" }) {
                        Text("FocusManagement")
                    }
                }

            }
        } else {
            // Fullscreen Demo View
            Box(modifier = Modifier.fillMaxSize()) {
                when (currentDemo) {
                    "LazyGrid" -> LazyGridDemo()
                    "LazyList" -> LazyListDemo()
                    "Flow" -> FlowLayout()
                    "Box" -> BoxDemo()
                    "RowColumn" -> RowColumnDemoPreview()
                    "CustomViewDemo" -> CustomViewDemo()
                    "Counter" -> Counter()
                    "NumberGuessScreenRoot" -> NumberGuessScreenRoot()
                    "ShapDemo" -> ShapDemo()
                    "FocusManagement" -> FocusManagementDemo()
                }
            }
        }
    }
}

@Preview()
@Composable
fun GreetingPreview() {
    MyComposeDemoTheme {
        DemoSelector { }
    }
}


