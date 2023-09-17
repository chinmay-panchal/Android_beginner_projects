package com.example.placed_food_order_shower

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.placed_food_order_shower.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.btnOrder
//import kotlinx.android.synthetic.main.activity_main.eT1
//import kotlinx.android.synthetic.main.activity_main.eT2
//import kotlinx.android.synthetic.main.activity_main.eT3
//import kotlinx.android.synthetic.main.activity_main.eT4

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY = "com.example.placed_food_order_shower"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnOrder.setOnClickListener {
            val ordersPlaced= binding.eT1.text.toString() + " " + binding.eT2.text.toString() + " "+
                    binding.eT3.text.toString() + " " + binding.eT4.text.toString()

            intent = Intent(this, Order::class.java)
            intent.putExtra(KEY, ordersPlaced)
            startActivity(intent)
        }
    }
}