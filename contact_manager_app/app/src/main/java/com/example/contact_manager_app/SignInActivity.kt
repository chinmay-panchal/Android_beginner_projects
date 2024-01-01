package com.example.contact_manager_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact_manager_app.databinding.ActivityContactScreenBinding
import com.example.contact_manager_app.databinding.ActivitySignInBinding
import com.example.contact_manager_app.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener{

            val uniqueId = binding.userNameEditText.editText?.text.toString()
            val Password = binding.PasswordEditText.editText?.text.toString()

            if(uniqueId.isNotEmpty() && Password.isNotEmpty()){
                readData(uniqueId,Password)
            }
            else{
                Toast.makeText(this, "Please enter user id and Password", Toast.LENGTH_SHORT).show()
            }
        }
    } // on create method over // error isliye kyunki readData function banana baki h

    private fun readData(uniqueId: String, Password: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if(it.exists()){
                val realPassword = it.child("password").value
                if(realPassword==Password){
                    val intentContact = Intent(this, ContactScreen::class.java)
                    startActivity(intentContact)
                }
                else{
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "User does not exists", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed, error in DB", Toast.LENGTH_SHORT).show()
        }
    }

}
