package com.example.placed_food_order_shower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//import com.example.placed_food_order_shower.databinding.ActivityOrderBinding

//import kotlinx.android.synthetic.main.activity_order.tVOrder // this is for only kotlin extention

//private lateinit var binding: ActivityOrderBinding
class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val tvorder = findViewById<TextView>(R.id.tVOrder)
        val ordersOfCustomers = intent.getStringExtra(MainActivity.KEY)
        tvorder.text=ordersOfCustomers.toString()
    }
}