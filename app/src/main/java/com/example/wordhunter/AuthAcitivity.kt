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
import com.google.firebase.firestore.FirebaseFirestore

class AuthAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth_acitivity)

        val sp = getSharedPreferences("PC", Context.MODE_PRIVATE)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        val db = FirebaseFirestore.getInstance()

        // Переход на экран регистрации
        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Обработка нажатия на кнопку "Войти"
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPass.text.toString().trim()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Проверка пользователя в Firestore
            db.collection("users")
                .whereEqualTo("login", login)
                .whereEqualTo("password", password)
                .get()
                .addOnSuccessListener { documents ->
                    if (!documents.isEmpty) {
                        // Авторизация успешна
                        Toast.makeText(this, "Добро пожаловать, $login!", Toast.LENGTH_LONG).show()

                        // Сохранение логина пользователя в SharedPreferences
                        sp.edit().putString("Login", login).apply()

                        // Переход на HomeActivity
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                         // Завершаем текущую активность, чтобы нельзя было вернуться назад
                    } else {
                        // Учетные данные неверны
                        Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener { e ->
                    // Обработка ошибки подключения к Firestore
                    Toast.makeText(this, "Ошибка подключения. Попробуйте позже.", Toast.LENGTH_LONG).show()
                }
        }
    }
}
