package com.example.jetpackcompose.textexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextViewComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SimpleText()
                styledText()
                CenteredText()
                CustomFontText()
                ClickableTextExample()
            }
        }
    }
}


@Preview
@Composable
fun SimpleText() {
    Text(text = "Hello, Jetpack Compose!")
}

@Preview
@Composable
fun styledText() {
    Text(
        text = "Sytled text",
        fontSize = 20.sp,
        color = Color.Blue,
        fontWeight = FontWeight.Bold
    )
}


@Preview
@Composable
fun CenteredText() {
    Text(
        textAlign = TextAlign.Left,
        text = "This is the long\ntext that needs to be wrapped text",
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun CustomFontText() {
    Text(
        text = "Custom Font",
        fontFamily = FontFamily.Cursive,
        fontSize = 22.sp
    )
}

@Preview
@Composable
fun ClickableTextExample() {
    Text(
        text = "Click Me!",
        color = Color.Red,
        modifier = Modifier.clickable { Log.d("Text", "Clicked!") }
    )
}
