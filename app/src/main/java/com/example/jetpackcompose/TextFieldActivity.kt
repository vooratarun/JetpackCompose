package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle


class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Column {
                Text("Hi hello")
                AutoCompleteTextField()
                Spacer(Modifier.padding(top = 20.dp))
                SimpleTextField()
                Spacer(Modifier.padding(top = 20.dp))
                OutlinedTextFieldExample()
                Spacer(Modifier.padding(top = 20.dp))
                PasswordTextFieldExample()
                Spacer(Modifier.padding(top = 20.dp))
                PlaceholderTextField()
                Spacer(Modifier.padding(top = 20.dp))
                LimitedTextField()
                Spacer(Modifier.padding(top = 20.dp))
                ReadOnlyTextField()
                CustomTextField()
                MultiLineTextField()

            }
        }

    }
}

@Preview
@Composable
fun SimpleTextField(){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your name") }
    )
}

@Preview
@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your name") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordTextFieldExample() {

    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter your password") },
        visualTransformation = if(isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(
                    imageVector = if(isVisible) Icons.Default.Favorite else Icons.Filled.ThumbUp,
                    contentDescription = if(isVisible) "Hide password" else "Show password"
                )
            }
        }
    )
}

@Composable
fun PlaceholderTextField(){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your name") },
        placeholder = { Text("Name") }
    )
}

@Composable
fun LimitedTextField() {
    var text by remember { mutableStateOf("") }
    val maxLength = 10

    TextField(
        value = text,
        onValueChange = {if (it.length <= maxLength) text = it},
        label = { Text("Max 10 chars") },
    )

}

@Composable
fun ReadOnlyTextField() {
    TextField(
        value = "this is read only",
        onValueChange = {  },
        readOnly = true,
        label = { Text("Enter your name") },
    )
}

@Composable
fun CustomTextField() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                isError = it.length < 3 // Simple validation
            },
            label = { Text("Enter name") },
            isError = isError,
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Person Icon") },
            trailingIcon = {
                if (isError) Icon(Icons.Filled.Warning, contentDescription = "Error", tint = Color.Red)
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        if (isError) {
            Text("Minimum 3 characters required!", color = Color.Red, fontSize = 12.sp)
        }
    }
}


@Composable
fun MultiLineTextField() {
    var text by remember { mutableStateOf("") }
    val maxLength = 10

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) text = it
            },
            label = { Text("Write your thoughts...") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5,
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
        )
        Text("${text.length} / $maxLength", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.align(Alignment.End))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteTextField() {
    val suggestions = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape")
    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                expanded = it.isNotEmpty()
            },
            label = { Text("Enter Fruit Name") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            suggestions.filter { it.contains(text, ignoreCase = true) }.forEach { suggestion ->
                DropdownMenuItem(
                    text = { Text(suggestion) },
                    onClick = {
                        text = suggestion
                        expanded = false
                    }
                )
            }
        }
    }
}

