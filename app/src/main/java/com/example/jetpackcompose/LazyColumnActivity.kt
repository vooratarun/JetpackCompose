package com.example.jetpackcompose

import android.R.attr.content
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.collections.mutableListOf

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column {
                Text("Hello world")
                Spacer(modifier = Modifier.padding(top = 20.dp))
                // BlogCategory(R.drawable.r10074,"Programming","Learn different Languages")
                // PreviewItem()
                SimpleLazyColumn()
            }

        }
    }
}

//@Preview

@Preview(showSystemUi = true)
@Composable
fun PreviewItem() {

//    BlogCategory(R.drawable.r10074,"Programming","Learn different Languages")

//    Column(Modifier.verticalScroll(rememberScrollState())) {
//        getCategoryList().map { item ->
//            BlogCategory(item.img, item.title, item.subtitle)
//        }
//    }


    LazyColumn(modifier = Modifier.padding(16.dp), content = {
        items(getCategoryList()) { item ->
            BlogCategory(item.img,item.title,item.subtitle)
        }
    })
}


@Composable
fun SimpleLazyColumn() {
    val itemsList = List(20) { "Item #$it" }  // Generate 20 items
    val myList = List(20) { "Item #$it" }  // Creates a List<String>


    LazyColumn {
        items(myList) { item ->  // ✅ Correct usage
            Text(text = item)
        }
    }
}


@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = "Image",
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subtitle, Modifier.weight(.8f))
        }
    }
}


@Composable
fun ItemDescription(title: String, subtitle: String, modifier: Modifier) {

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Thin
        )

    }
}


@Composable
fun LazyColumnWithCards() {
    val itemsList = List(20) { "Item #$it" }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(itemsList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


data class Category(val img: Int, val title: String, val subtitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming2", "learn different languages"));
    list.add(Category(R.drawable.r10074, "programming3", "learn different languages"));

    return list;
}