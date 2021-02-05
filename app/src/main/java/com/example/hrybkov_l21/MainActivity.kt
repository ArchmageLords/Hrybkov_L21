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
        setNewData()
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

    private fun setNewData() {
        val film = Film("Baby Boss", "Cartoon", 3.12F, 200.00F, R.drawable.boss_baby)
        findViewById<FilmsViewGroup>(R.id.filmsViewGroupExample).apply {
            setTitle(film.title)
            setCategory(film.category)
            setRating(film.rating)
            setPrice(film.price)
            setImage(film.image)
        }
    }
}