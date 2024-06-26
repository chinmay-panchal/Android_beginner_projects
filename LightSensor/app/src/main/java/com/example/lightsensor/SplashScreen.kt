package com.example.lightsensor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}