package com.example.hrybkov_l21

import androidx.annotation.DrawableRes

data class Film(
    val title: String,
    val category: String,
    val rating: Float,
    val price: Float,
    @DrawableRes val image: Int
)