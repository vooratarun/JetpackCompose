package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LambdaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Column {
                Text("Hello")
                MyButton {
                    println("Button clicked!")
                    Toast.makeText(this@LambdaActivity, "button clicked!", Toast.LENGTH_SHORT)
                        .show()
                }
                Greeting("Ram", onGreet = { value ->
                    Toast.makeText(this@LambdaActivity, "$value!", Toast.LENGTH_SHORT).show()

                })

                val names = listOf("Alice","Bob","Charlie")
                NameList(names) { name ->
                    Toast.makeText(this@LambdaActivity, "$name", Toast.LENGTH_SHORT).show()
                }

                var isFeatureEnabled by remember { mutableStateOf(false) }
                ToggleSwitch(isFeatureEnabled) { newState ->
                    print(newState)
                    isFeatureEnabled = newState
                }
                HorizontalScrollableComponent(getPersonList());

            }
        }
    }
}

@Composable
fun MyButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Click me")
    }
}

@Composable
fun Greeting(name: String, onGreet: (String) -> Unit) {

    Button(onClick = {
        onGreet(name + " dummy")
    }) {
        Text("Greet $name")
    }
}

@Composable
fun NameList(names: List<String>, onItemClick: (String) -> Unit) {

    LazyColumn {
        items(names) { name ->
            Text(
                text = name,
                modifier = Modifier.clickable { onItemClick(name) }
                    .padding(20.dp)
            )
        }
    }

}

@Composable
fun ToggleSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val context = LocalContext.current
    Row(){
        Text(text = "Enable Feature")
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun HorizontalScrollableComponent(personList: List<Person>) {

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                state = scrollState,
            ),
        content = {
            for ((index, person) in personList.withIndex()) {

                Card(
                    shape = RoundedCornerShape(4.dp),
//                    backgroundColor = colors[index % colors.size],
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        person.name,
                        modifier = Modifier.padding(16.dp),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                    )
                }
            }
        })
}
