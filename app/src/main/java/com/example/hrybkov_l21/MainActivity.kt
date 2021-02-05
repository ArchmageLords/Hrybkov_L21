package com.example.hrybkov_l21


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hrybkov_l21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        goToFan()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun goToFan() {
        binding.btnGoToFan.setOnClickListener {
            FanActivity.start(this)
        }
    }
}