package com.gaolvgo.view_study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp

/**
 * 描述：画圆
 * @author fangdongdong
 * @date   2021/4/12 16:31
 */
class StudyDrawCircle(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        this.isAntiAlias = true
    }

    @SuppressLint("ResourceAsColor")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        paint.style = Paint.Style.FILL
        canvas.drawCircle(width / 4f, height / 4f, 50.px2dp(), paint)

        paint.style = Paint.Style.STROKE
        canvas.drawCircle(width / 4f, height / 4f * 3, 50.px2dp(), paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.parseColor("#3700B3")
        canvas.drawCircle(width / 4f * 3, height / 4f, 50.px2dp(), paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20.px2dp()
        paint.color = Color.BLACK
        canvas.drawCircle(width / 4f * 3, height / 4f * 3, 50.px2dp(), paint)

    }
}