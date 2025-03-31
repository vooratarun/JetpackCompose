package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jetpackcompose.textexample.TextViewComposeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val buttonExam = findViewById<Button>(R.id.buttonex);
        buttonExam.setOnClickListener {
            val intent : Intent = Intent(this, ButtonsActivity::class.java);
            startActivity(intent)
        }

        val textviewsex = findViewById<Button>(R.id.textviewsexample);
        textviewsex.setOnClickListener {
            val intent : Intent = Intent(this, TextViewComposeActivity::class.java);
            startActivity(intent)
        }

        val textfield = findViewById<Button>(R.id.textfield);
        textfield.setOnClickListener {
            val intent : Intent = Intent(this, TextFieldActivity::class.java);
            startActivity(intent)
        }

        val rowColumn = findViewById<Button>(R.id.rowcolumn);
        rowColumn.setOnClickListener {
            val intent : Intent = Intent(this, RowColumnActivity::class.java);
            startActivity(intent)
        }

        val lazyColumn = findViewById<Button>(R.id.lazycolumn);
        lazyColumn.setOnClickListener {
            val intent : Intent = Intent(this, LazyColumnActivity::class.java);
            startActivity(intent)
        }

    }
}