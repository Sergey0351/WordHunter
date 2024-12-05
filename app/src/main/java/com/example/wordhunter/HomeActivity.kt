package com.example.wordhunter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordhunter.databinding.ActivityMainBinding
import com.example.wordhunter.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Check point
        binding.bNav.setOnNavigationItemSelectedListener {
            true
        }
        //
    }
}