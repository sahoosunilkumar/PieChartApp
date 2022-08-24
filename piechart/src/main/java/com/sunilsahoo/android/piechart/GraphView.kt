package com.sunilsahoo.android.piechart

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.view.doOnLayout
import kotlin.math.min


class GraphView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var coordinates: RectF
    private var temp = 0f
    private var circleInfo: CircleInfo? = null
    private var pieInfo: PieInfo? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        pieInfo?.let { info->
            info.segments?.let {
            for (i in it.indices) {
                if (i == 0) {
                    temp = 0f
                } else {
                    temp += it[i - 1].percentage ?: 0f
                }
                paint.color = it[i].color
                canvas.drawArc(coordinates, temp, it[i].percentage ?: 0f, true, paint)
            }
        }
        }

    }

    fun update(pieInfo: PieInfo) {
        this.pieInfo = pieInfo
        pieInfo.segments?.let {
            doOnLayout {
                val min:Float = min(width, height).toFloat()
                coordinates =
                    RectF(0f, 0f, min, min)
                val cx = (coordinates.left + coordinates.right) / 2
                val cy = (coordinates.top + coordinates.bottom) / 2
                val radius = cx * 0.6f
                circleInfo = CircleInfo(cx, cy, radius, pieInfo.color)
                invalidate()
            }
        }
    }
}



