package com.example.listviewbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // list view ki id lelo (step 1)
        val listView = findViewById<ListView>(R.id.listView)

        // make an array for data storing (step 2)
        val taskList = arrayListOf<String>()
        taskList.add("List view part 2")
        taskList.add("Upload on twitter")
        taskList.add("Complete the App Dev Project")
        taskList.add("Work on resume")
        taskList.add("Improve internet presence")

       // creating an adapter which converts the data into view item in a particular design (step 3)
        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)

        // list view m adapter daldene ka, matlab design joki humne banayi + data (step 4)
        listView.adapter = adapterForMyListView

        listView.setOnItemClickListener { parent, view, position, id ->
            // agar kisi task pe click kiya toh toast dikhana h
            val text = "Clicked on Item: "+ (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

}