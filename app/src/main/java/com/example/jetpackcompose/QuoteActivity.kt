package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcompose.DataManager.data
import com.example.jetpackcompose.screens.QueueListScreenNew
import com.example.jetpackcompose.screens.QuoteDetail

class QuoteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManager.loadFromAssetFile()
        setContent {
            App()

        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current

    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {

//            QueueListScreen(data = DataManager.data, onClick = { quote ->
//                DataManager.switchPages(quote)
//            })


//            val arraydata : Array<String> = arrayOf("a","b","c");
//            QueueListScreen2(data = arraydata, onClick = {
//                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
//                println("printing value:  $it")
//            })

            QueueListScreenNew(data, onClick = { item ->
                Toast.makeText(context, item.text, Toast.LENGTH_SHORT).show()
            })

        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }


    } else {
        Text(
            "Loading...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

enum class Pages {
    LISTING,
    DETAIL

}