package com.example.basicphotoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImageIndex = 0
    lateinit var image : ImageView

    var names = arrayOf("Jordan Peterson", "Elon Musk", "Virat Kohli", "Ratan Tata")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView2)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImageIndex"

            // string id ka address lene k liye next line
            // string id ka address directly isliye access nahi kiya kyunki
            // hume baar baar change karna h variable ko so alag se access karrhe h

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            // find view by id k andar baar baar different id's aayengi so specific nahi likhskte
            // programmatically humne int address ko achieve karliya

            image.alpha= 0f

            currentImageIndex = (4+ currentImageIndex-1)%4
            val idImageToShowString = "pic$currentImageIndex"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImageIndex]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImageIndex"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImageIndex = (4+ currentImageIndex+1)%4
            val idImageToShowString = "pic$currentImageIndex"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImageIndex]
        }
    }
}