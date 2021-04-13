package com.gaolvgo.view_study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/12 16:31
 */
class StudyDrawCircle(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    }

    private val heightSpan = 60.px2dp()
    private val heightSpanInt = 60.px2dpInt()

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        paint.style = Paint.Style.FILL
        canvas.drawCircle(width / 4f, heightSpan, 50.px2dp(), paint)

        paint.style = Paint.Style.STROKE
        canvas.drawCircle(width / 4f, heightSpan * 3, 50.px2dp(), paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.parseColor("#3700B3")
        canvas.drawCircle(width / 4f * 3, heightSpan, 50.px2dp(), paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20.px2dp()
        paint.color = Color.BLACK
        canvas.drawCircle(width / 4f * 3, heightSpan * 3, 50.px2dp(), paint)

        //使用 canvas.drawRect() 方法画矩形
        paint.strokeWidth = 1f
        val rect = Rect(
            width / 4 - 50.px2dpInt(),
            heightSpanInt * 4 + 20.px2dpInt(),
            width / 4 + 50.px2dpInt(),
            heightSpanInt * 6 - 20.px2dpInt()
        )
        canvas.drawRect(rect, paint)

        //使用 canvas.drawPoint() 方法画点  一个圆点，一个方点
        paint.strokeWidth = 10.px2dp()
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawPoint(width / 4f * 3 - 30.px2dp(), heightSpan * 5, paint)
        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawPoint(width / 4f * 3 + 30.px2dp(), heightSpan * 5, paint)

        //使用 canvas.drawOval() 方法画椭圆
        paint.strokeWidth = 1f
        canvas.drawOval(
            width / 4f - 50.px2dp(),
            heightSpan * 7 - 20.px2dp(),
            width / 4f + 50.px2dp(),
            heightSpan * 7 + 20.px2dp(), paint
        )

        //使用 canvas.drawLine() 方法画直线
        canvas.drawLine(
            width / 4f * 3 - 50.px2dp(),
            heightSpan * 7 - 20.px2dp(),
            width / 4f * 3 + 50.px2dp(),
            heightSpan * 7 + 20.px2dp(), paint
        )

        //使用 canvas.drawRoundRect() 方法画圆角矩形
        val rectRound = RectF(
            width / 4f - 50.px2dpInt(),
            heightSpanInt * 8f + 20.px2dpInt(),
            width / 4f + 50.px2dpInt(),
            heightSpanInt * 10f - 20.px2dpInt()
        )
        canvas.drawRoundRect(rectRound, 10.px2dp(), 10.px2dp(), paint)

        //使用 canvas.drawArc() 方法画弧形和扇形
        /*drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
        startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        sweepAngle 是弧形划过的角度；
        useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形*/
        paint.style = Paint.Style.FILL
        val rectArc = RectF(
            width / 4f * 3 - 50.px2dpInt(),
            heightSpanInt * 8f + 20.px2dpInt(),
            width / 4f * 3 + 50.px2dpInt(),
            heightSpanInt * 10f - 20.px2dpInt()
        )
        canvas.drawArc(rectArc, 180f, 270f, true, paint)

    }
}