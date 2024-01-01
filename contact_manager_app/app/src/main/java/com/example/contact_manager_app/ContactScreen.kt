package com.example.contact_manager_app

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.contact_manager_app.databinding.ActivityContactScreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContactScreen : AppCompatActivity() {

    private lateinit var binding: ActivityContactScreenBinding

    private lateinit var contactreference : DatabaseReference

    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        val buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        val buttonFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        buttonGood.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Thanks for showing up! Your presence is truly appreciated.", Toast.LENGTH_SHORT).show()
        }

        buttonFeedback.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScmjmzX5dYUeIVH-59v_RW8FHFSAnYDQfMhzRPy5LBgfZoJpA/viewform?usp=sf_link")
            startActivity(intent)
            dialog.dismiss()
        }

        binding.btnAdd.setOnClickListener{
            val name = binding.IDname.editText?.text.toString()
            val email = binding.IDemail.editText?.text.toString()
            val phoneNumber = binding.IDnumber.editText?.text.toString()

            if(name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()){
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                val contact = Contact(name,email,phoneNumber)
                contactreference = FirebaseDatabase.getInstance().getReference("Contacts")
                contactreference.child(phoneNumber).setValue(contact).addOnSuccessListener {
                    binding.IDname.editText?.text?.clear()
                    binding.IDemail.editText?.text?.clear()
                    binding.IDnumber.editText?.text?.clear()
                    dialog.show()
//                    Toast.makeText(this,"Contact Saved", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}