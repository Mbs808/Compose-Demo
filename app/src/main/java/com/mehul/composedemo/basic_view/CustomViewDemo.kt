@file:OptIn(
    ExperimentalLayoutApi::class, ExperimentalLayoutApi::class,
    ExperimentalLayoutApi::class, ExperimentalLayoutApi::class, ExperimentalLayoutApi::class
)

package com.mehul.composedemo.basic_view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehul.composedemo.R
import com.mehul.composedemo.ui.theme.MyComposeDemoTheme

private val tags = listOf("Android", "Jetpack", "Compose", "Kotlin", "JAVA Script", "Python")

private val listofService = mapOf(
    R.drawable.android to "Android",
    R.drawable.ui to "Ui UX",
    R.drawable.website to "Website",
    R.drawable.multi_level_marketing to "Marketing",
    R.drawable.image_ic to "Image",
    R.drawable.videos to "Videos",
    R.drawable.music__1_ to "Music",
)

@Composable
fun CustomViewDemo(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    // Manage the state of the clicked chip
    val selectedTag = remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        item {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    modifier = Modifier
                        .fillMaxWidth(),

                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )
                TopHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }

        }
        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 20.dp),
                color = Color.LightGray,
            )
        }
        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                tags.forEach { item ->
                    val isSelected = selectedTag.value == item

                    AssistChip(
                        onClick = {
                            selectedTag.value = if (isSelected) null else item
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        },
                        label = {
                            Text(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                                text = item,
                                color = if (isSelected) Color.White else Color.DarkGray,
                                fontSize = 15.sp
                            )
                        },
                        modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(25.dp),
                        border = null,
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = if (isSelected) Color.Blue else Color.LightGray,
                            labelColor = if (isSelected) Color.White else Color.DarkGray,
                            disabledContainerColor = Color.Transparent,
                            disabledLabelColor = Color.DarkGray
                        ),
                    )
                }
            }
        }


        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 20.dp),
                color = Color.LightGray,
            )
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                text = stringResource(R.string.text_demo),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                text = stringResource(R.string.offer),
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {

                items(listofService.entries.toList()) { (drawableItem, lable) ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(8.dp)

                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableItem),
                            contentDescription = lable,
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text =  lable,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 5.dp)

                        )
                    }

                }
            }
        }

        item {
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 20.dp),
                color = Color.LightGray,
            )
        }
    }
}

@Composable
fun TopHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.5f))
            .padding(10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = "Mehul Sarvaiya",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            LabeledIcon(
                modifier = Modifier.padding(top = 5.dp),
                text = "Android Developer",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            )

            LabeledIcon(
                modifier = Modifier.padding(top = 5.dp),
                text = "Origin Infotech, android, ios, website, ui-ux designer ",
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )
                }
            )
        }

        FlowRow(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.End,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    tint = Color.Red
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 15.sp
                            )
                        ) {
                            append("302 / ")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                fontSize = 12.sp
                            )
                        ) {
                            append("Sky Zone, Jakatnaka,  Surat")
                        }
                    },
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
fun LabeledIcon(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        icon()

        Spacer(modifier = Modifier.width(7.dp))

        Text(
            text = text,
            color = Color.DarkGray,
            fontSize = 15.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomViewDemoTabletPreview() {
    MyComposeDemoTheme {
        CustomViewDemo()
    }

}