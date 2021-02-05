package com.example.hrybkov_l21

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hrybkov_l21.databinding.FanActivityBinding

class FanActivity : AppCompatActivity() {

    private lateinit var binding: FanActivityBinding

    companion object {
        fun start(context: Context){
            val intent = Intent(context, FanActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        binding = FanActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}