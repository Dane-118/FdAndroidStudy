package com.gaolvgo.view_study.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/12 16:31
 */
class StudyDrawColor(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

//    private val paint = Paint().apply {
//        this.isAntiAlias = true
//        this.style = Paint.Style.FILL
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        paint.color = Color.YELLOW
        canvas.drawColor(Color.YELLOW)

    }
}