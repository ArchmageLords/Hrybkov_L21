package com.example.hrybkov_l21

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.hrybkov_l21.FanControllerView.Companion.mActiveSelection

class RotatingFanImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrs: Int = 0
) : AppCompatImageView(context, attributeSet, defAttrs) {


    private var rotationDegrees = 0

    init {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_fan)
        setImageBitmap(bitmap)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate((width / 2).toFloat(), (height / 2).toFloat())
        canvas.rotate(rotation(mActiveSelection).toFloat())
        canvas.translate((-width / 2).toFloat(), (-height / 2).toFloat())

        postInvalidateOnAnimation()
        super.onDraw(canvas)
    }

    private fun rotation(delta: Int): Int {
        rotationDegrees = (rotationDegrees + delta * 5) % 360
        return rotationDegrees
    }

}