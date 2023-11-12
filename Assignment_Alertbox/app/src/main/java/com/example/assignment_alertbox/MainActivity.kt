package com.example.assignment_alertbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.assignment_alertbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv2.setOnClickListener {
            val options = arrayOf("Udemy", "Coursera", "Saumya didi's Yt channel")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which source you will recommend your friend to learn Android Development concepts?")
            builder2.setSingleChoiceItems(options, -1, DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when user clicks on any option
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // WHat action should be performed when Yes is clicked ?
                Toast.makeText(this,"You Clicked on Submit",Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //  WHat action should be performed when Yes is clicked ?
                Toast.makeText(this,"You Clicked on Decline",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }

        binding.tv3.setOnClickListener {
            val options = arrayOf("C++", "Java", "Kotlin")

            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which programming languages you use frequently? (you can choose multiple options)")
            builder2.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // WHat action should be performed when Yes is clicked ?
                Toast.makeText(this,"You Clicked on Submit",Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //  WHat action should be performed when Yes is clicked ?
                Toast.makeText(this,"You Clicked on Decline",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }

        binding.tv4.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close the App")
            builder1.setIcon(R.drawable.baseline_reply_all_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // WHat action should be performed when Yes is clicked ?
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                //  WHat action should be performed when Yes is clicked ?
                Toast.makeText(this,"You Clicked on No",Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
    }

}