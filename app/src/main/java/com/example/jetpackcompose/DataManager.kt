package com.example.jetpackcompose

import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcompose.models.Quote

object DataManager {

    var data = emptyArray<Quote>();
    var currentQuote :Quote? = null;

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)


    fun loadFromAssetFile() {
        val  q1 = Quote("Time is the most valuable thing a man can spend", "Steve Jobs");
        val q2 = Quote("Time is the most valuable thing a man can spend", "Steve Jobs");
        val q3 = Quote("Time is the most valuable thing a man can spend", "Steve Jobs");

        data = arrayOf(q1,q2,q3);
        isDataLoaded.value = true;
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentPage.value = Pages.DETAIL
            currentQuote = quote
        } else {
            currentPage.value = Pages.LISTING
        }
    }

}