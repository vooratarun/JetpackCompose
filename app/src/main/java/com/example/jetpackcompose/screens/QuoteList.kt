package com.example.jetpackcompose.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.jetpackcompose.models.Quote
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuoteList(data : Array<Quote>, onClick: (quote: Quote)->Unit ) {

    LazyColumn(content = {
        items(data) {
            QuoteListItem(quote = it){
                onClick(it)
            }
        }
    })
}

