package com.example.explicit_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIntent = findViewById<Button>(R.id.btnCLickMe)

        btnIntent.setOnClickListener{
            intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}