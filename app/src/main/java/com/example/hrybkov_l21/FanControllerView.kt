package com.example.hrybkov_l21

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class FanControllerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    private var mWidth = 0f
    private var mHeight = 0f
    private val selectionCount = 4
    private val mTextPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mDialPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mRadius = 0f
    companion object {
        var mActiveSelection = 0
    }
    private val mTempLabel = StringBuffer(8)
    private val mTempResult = FloatArray(2)

    init {
        mTextPaint.color = Color.BLACK
        mTextPaint.style = Paint.Style.FILL_AND_STROKE
        mTextPaint.textAlign = Paint.Align.CENTER
        mTextPaint.textSize = 40f
        mDialPaint.color = Color.GRAY
        mActiveSelection = 0

        setOnClickListener {
            mActiveSelection = (mActiveSelection + 1) % selectionCount
            if (mActiveSelection >= 1) {
                mDialPaint.color = Color.GREEN
            } else {
                mDialPaint.color = Color.GRAY
            }
            invalidate()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat();
        mHeight = h.toFloat();
        mRadius = (min(mWidth, mHeight) / 2 * 0.8f);
    }

    private fun computeXYForPosition(pos: Int, radius: Float): FloatArray {
        val result = mTempResult
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + pos * (Math.PI / 4)
        result[0] = (radius * cos(angle)).toFloat() + mWidth / 2
        result[1] = (radius * sin(angle)).toFloat() + mHeight / 2
        return result
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle((mWidth / 2), (mHeight / 2), mRadius, mDialPaint)
        val labelRadius = mRadius + 20
        val label = mTempLabel
        for (i in 0 until selectionCount) {
            val xyData = computeXYForPosition(i, labelRadius)
            val x = xyData[0]
            val y = xyData[1]
            label.setLength(0)
            label.append(i)
            canvas.drawText(label, 0, label.length, x, y, mTextPaint)
        }
        val markerRadius = mRadius - 35
        val xyData = computeXYForPosition(
            mActiveSelection,
            markerRadius
        )
        val x = xyData[0]
        val y = xyData[1]
        canvas.drawCircle(x, y, 20f, mTextPaint)
    }
}