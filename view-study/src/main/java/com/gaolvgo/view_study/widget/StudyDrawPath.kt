package com.gaolvgo.view_study.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt
import kotlin.math.cos
import kotlin.math.sin

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/12 16:31
 */
class StudyDrawPath(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val angles = floatArrayOf(60f, 90f, 150f, 60f)
    private val colors = listOf(
        Color.parseColor("#C2185B"),
        Color.parseColor("#00ACC1"),
        Color.parseColor("#558B2F"),
        Color.parseColor("#5D4037")
    )

    private val heightSpan = 150.px2dp()
    private val radius = 100.px2dp()
    private val offset = 10.px2dp()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var startAngle = 0f
        for ((index, angle) in angles.withIndex()) {
            if (index == 0) {
                canvas.save()
                canvas.translate(
                    offset * cos(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat(),
                    offset * sin(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat()
                )
            }
            paint.color = colors[index]
            canvas.drawArc(
                width / 2f - radius,
                heightSpan - radius,
                width / 2f + radius,
                heightSpan + radius,
                startAngle,
                angle,
                true,
                paint
            )
            startAngle += angle
            if (index == 0) {
                canvas.restore()
            }
        }

    }
}