package com.gaolvgo.view_study.widget.study8

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/21 15:38
 */
class StudyEight1(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var radius = 50.px2dp()
        set(value) {
            field = value
            invalidate()
        }

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(radius, radius, radius, paint)

    }
}