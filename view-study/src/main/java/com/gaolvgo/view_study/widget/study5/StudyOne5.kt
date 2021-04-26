package com.gaolvgo.view_study.widget.study5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.gaolvgo.view_study.R

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/22 20:12
 */
class StudyOne5(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val fontMetrics = Paint.FontMetrics()

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        paint.color = Color.parseColor("#FFC107")
        canvas.drawCircle(200f, 200f, 200f, paint)
        super.onDraw(canvas)

        paint.textSize = 28f

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        canvas.drawText(
            resources.getString(R.string.image_size, bitmap.width, bitmap.height),
            20f,
            40f,
            paint
        )

    }
}