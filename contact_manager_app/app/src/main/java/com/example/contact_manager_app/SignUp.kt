package com.example.contact_manager_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact_manager_app.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val etName = findViewById<EditText>(R.id.etName)
//        val EtName = binding.etName.editText

        binding.signButton.setOnClickListener {
            val name = binding.etName.editText?.text.toString()
            val mail = binding.etMail.editText?.text.toString()
            val uniqueId = binding.UserID.editText?.text.toString()
            val password = binding.UserPassword.editText?.text.toString()

//            val name = EtName?.text.toString()

            val user = User(name,mail,password,uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                binding.etName.editText?.text?.clear()
                binding.etMail.editText?.text?.clear()
                binding.UserID.editText?.text?.clear()
                binding.UserPassword.editText?.text?.clear()

                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignIN.setOnClickListener {
            val openSignInActivity = Intent(this, SignInActivity::class.java)
            startActivity(openSignInActivity)
        }
    }
}