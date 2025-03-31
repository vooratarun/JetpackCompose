package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Hello CheezyCode")
                sayCheezy("CheezyCode")
//                PreviewFunction2()
//                PreviewFunction3()
                BasicButtonExample()
                styledButton()
                OutlinedButtonExample()
                ButtonWithIconExample()
                IconButtonExample()
            }

        }
    }
}

@Composable
fun sayCheezy(name: String){
    Text(
        text = "Hello $name",
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        color = Color.Red,
        textAlign = TextAlign.Left

    )
}

//
//@Preview(showBackground = true, name = "Hello message", widthDp = 300 , heightDp = 500)
//@Composable
//fun PreviewFunction() {
//    sayCheezy("tarun")
//}



@Preview(showBackground = true, name = "hello message 2")
@Composable
fun PreviewFunction2() {
    Image(
        painter = painterResource(id = R.drawable.r10074),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,

    )
}

@Preview(showBackground = true, name = "Hello message 3")
@Composable
fun PreviewFunction3() {
   androidx.compose.material3.Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Blue

        )
   ) {
        Text(text = "Hello Compose")
        Image(
            painter = painterResource(id = R.drawable.r10074),
            contentDescription = "Image")

   }

}

@Preview
@Composable
fun BasicButtonExample() {
    androidx.compose.material3.Button(
        onClick = {
        Log.d("Button", "Clicked!")
    }, border = BorderStroke(2.dp, Color.Blue)
    ) {
        Text(text = "Click Me now")
    }
}

@Preview
@Composable
fun styledButton() {
    androidx.compose.material3.Button(
        onClick = {
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)

    ) {
        Text(text = "Styled button", color = Color.White)
    }
}

@Preview
@Composable
fun OutlinedButtonExample() {
    OutlinedButton(
        onClick = { /* Handle click */ },
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Outlined Button", color = Color.Black)
    }
}

@Preview
@Composable
fun outlinebuttonexample2( ){
    androidx.compose.material3.Button(
        onClick = { /* Handle click */ },
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Outlined Button", color = Color.Black)
    }
}

@Preview
@Composable
fun ButtonWithIconExample() {
    androidx.compose.material3.Button(
        onClick = { /* Handle click */ },
        border = BorderStroke(2.dp,Color.Gray),
        shape = RoundedCornerShape(20.dp),

    ) {
        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Like")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Like")
    }
}

@Preview
@Composable
fun IconButtonExample() {
    IconButton(
        onClick = {}
    ) {
        Icon(imageVector = Icons.Default.Favorite,
            contentDescription = "Like")
    }
}