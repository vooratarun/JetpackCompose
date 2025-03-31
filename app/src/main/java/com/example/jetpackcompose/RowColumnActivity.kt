package com.example.jetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

class RowColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Text("Row column examples")
                Spacer(Modifier.padding(top = 20.dp))
                ColumnExample()
                Spacer(Modifier.padding(top = 20.dp))
                RowExample()
                ListViewItem()
                AdvancedRowExample()
                NestedRowExample()
                Spacer(Modifier.padding(top = 20.dp))
                AdvancedRowExample2()
            }
        }
    }
}

@Preview
@Composable
private fun ColumnExample(){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)

    }
}

@Composable
private fun RowExample() {
    Row(
        modifier = Modifier.background(Color.Green).padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }
}

@Preview
@Composable
private fun ListViewItem(){
    Row {
        Image(
            painter = painterResource(id = R.drawable.r10074),
            contentDescription = "Image",
            modifier = Modifier.size(100.dp)
        )
        Column {
            Text(
                text = "Title",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Description",
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview
@Composable
private fun AdvancedRowExample(){

    val context: Context = LocalContext.current  // Getting Context

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = {
            Toast.makeText(context, "Button Clicked!", Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Button 1 ")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = {}) {
            Text(text = "Button 2 ")
        }
    }
}

@Composable
fun NestedRowExample(){
    Column(
        modifier =
            Modifier
                .background(Color.Gray)
                .padding(16.dp)
    ) {
        Text(text = "Parent Row Item 1", modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .background(Color.Green)
                .padding(8.dp)
        ){
            Text(text = "Nested row - item 1", Modifier.padding(8.dp))
            Text(text = "Nested row - item 2", Modifier.padding(8.dp))
        }

        Text(text = "Parent Row Item 2", modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun AdvancedRowExample2() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically // Align items in the center
    ) {
        Text(
            text = "Left",
            modifier = Modifier
                .weight(1f) // Takes 1 part of the row
                .background(Color.Red)
                .padding(8.dp)
        )

        Text(
            text = "Right",
            modifier = Modifier
                .weight(2f) // Takes 2 parts of the row (twice as big as the first one)
                .background(Color.Blue)
                .padding(8.dp)
        )
    }
}
