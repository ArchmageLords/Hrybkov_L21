package com.example.hrybkov_l21

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class FilmsViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val tvTitle: TextView by lazy { findViewById(R.id.tvTitle) }
    private val tvCategory: TextView by lazy { findViewById(R.id.tvCategory) }
    private val tvPrice: TextView by lazy { findViewById(R.id.tvPrice) }
    private val ratingBar: RatingBar by lazy { findViewById(R.id.rating) }
    private val ivPoster: ImageView by lazy { findViewById(R.id.ivPoster) }

    init {
        inflate(context, R.layout.films_view_group, this)

        val attributes =
            context.obtainStyledAttributes(
                attrs,
                R.styleable.FilmsViewGroup,
                defStyleAttr,
                defStyleRes
            )

        ivPoster.setImageDrawable(attributes.getDrawable(R.styleable.FilmsViewGroup_poster))
        tvTitle.text = attributes.getString(R.styleable.FilmsViewGroup_title)
        tvCategory.text = attributes.getString(R.styleable.FilmsViewGroup_film_category)
        tvPrice.text = attributes.getString(R.styleable.FilmsViewGroup_price)
        ratingBar.rating = attributes.getFloat(R.styleable.FilmsViewGroup_rating, 0f)

        attributes.recycle()
    }

    fun setTitle(title: String) {
        tvTitle.text = title
    }

    fun setTitle(@StringRes title: Int) {
        tvTitle.text = resources.getString(title)
    }

    fun setCategory(category: String) {
        tvCategory.text = category
    }

    fun setCategory(category: Int) {
        tvCategory.text = resources.getString(category)
    }

    fun setRating(rating: Float) {
        ratingBar.rating = rating
    }

    fun setPrice(price: Float) {
        tvPrice.text = resources.getString(R.string.price_uah, price)
    }

    fun setImage(@DrawableRes poster: Int) {
        ivPoster.setImageResource(poster)
    }
}