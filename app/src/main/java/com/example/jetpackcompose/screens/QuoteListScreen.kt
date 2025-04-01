package com.example.jetpackcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.models.Quote


@Composable
fun QueueListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            style = MaterialTheme.typography.headlineMedium
        )
        QuoteList(data = data, onClick)
    }
}


@Composable
fun QueueListScreen2(data: Array<String>, onClick: (str: String) -> Unit) {

    Column {
        Text(
            text = "Quotes App new",
            style = MaterialTheme.typography.headlineMedium
        )
        Text("string")

        LazyColumn(content = {
            items(data) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable { onClick(it) }


                )
            }
        })
    }
}

@Composable
fun QueueListScreenNew(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(content = {
            items(data) {item ->
              Text(
                  text = item.text,
                  style = MaterialTheme.typography.bodyMedium,
                  modifier = Modifier
                      .padding(20.dp)
                      .clickable { onClick(item) }
              )
            }
        })
    }
}
