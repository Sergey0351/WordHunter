package com.example.wordhunter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE).edit()
        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthAcitivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener{
            if(userLogin.text.isEmpty()) {
                Toast.makeText(this,"Проверьте поле login", Toast.LENGTH_LONG).show()
            }
            else if(userPass.text.isEmpty() || userPass.text.length<5){
                Toast.makeText(this,"Пароль должен быть больше 4 символов", Toast.LENGTH_LONG).show()
            }
            else {
                val db = Firebase.firestore
                // Create a new user with a first and last name
                val user = hashMapOf(
                    "login" to userLogin.text.toString(),
                    "password" to userPass.text.toString()
                )


                db.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        sp.putString("Login",userLogin.text.toString()).commit()
                        startActivity(Intent(this,AuthAcitivity::class.java))
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Неполучилось,попробуйте позже", Toast.LENGTH_SHORT).show()
                    }
            }
        }


    }
}