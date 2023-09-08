package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var currentcolour = true
        val theme = findViewById<Button>(R.id.btnTheme)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        theme.setOnClickListener{

            if(currentcolour == true){
                layout.setBackgroundResource(R.color.black)
                theme.text = "Light Mode"
                currentcolour=false
            }
            else{
                layout.setBackgroundResource(R.color.white)
                theme.text = "Dark Mode"
                currentcolour=true
            }
//            layout.setBackgroundResource(R.color.black)
        }
    }
}