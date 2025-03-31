package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Column {
                Text("Hi hello")
                Modifier.
                    fillMaxWidth()
                    .padding(top = 40.dp)
                simpleTextField()

            }
        }

    }
}

@Composable
fun simpleTextField(){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your name") }
    )
}