package com.example.wordhunter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.example.wordhunter.databinding.ActivityMainBinding
import com.example.wordhunter.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        // Check point
        binding.bNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.Home -> replaceFragment(Home())
                R.id.Profile -> replaceFragment(Profile())
                R.id.Favorite -> replaceFragment(Favorite())

                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager =  supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}