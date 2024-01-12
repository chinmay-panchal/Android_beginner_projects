package com.example.listviewcustom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User> // step 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // step 2 (Storing all values in different arrays)
        val name = arrayOf("Chinmay", "Kamal", "Gajendra", "Elon", "Captain")

        val lastMsg = arrayOf("Jay Shri Krishna", "Jay Mahakaal", "Jay Shri Ram", "Hey what's up", "Hy")

        val lastMsgTime = arrayOf("6:25 AM", "7:30 AM", "9:24 AM", "6:25 PM", "7:30 PM")

        val phoneNumber = arrayOf("9999999995", "9999999991", "9999999992", "9999999993", "9999999994")

        // note that here int array is taken because address is stored in integer value
        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4)

        // step 3 (initialising userarraylist)
        userArrayList = ArrayList()

        // step 4 (making and storing objects as an element in the form of array in arraylist)
        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)
        }

        // step5 (accessing and assigning the adapter to the listview)
        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true // by default it is always true
        listView.adapter = MyAdapter(this, userArrayList) // MyAdapter is a custom class

        // step 6 (What will happen when you click on a particular text view)

        listView.setOnItemClickListener { parent, view, position, id ->
            // open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val intent = Intent(this, UserActivity::class.java)

            intent.putExtra("name", userName)
            intent.putExtra("phone", userPhone)
            intent.putExtra("imageId", imageId)
            startActivity(intent)
        }
    }
}