package com.gaolvgo.view_study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/14 10:44
 */
class StudyPaintThree(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    }
    private val path = Path()
    private val path1 = Path()

    private val heightSpan = 80.px2dp()
    private val heightSpanInt = 60.px2dpInt()
    private val radius = 60.px2dp()


    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.strokeWidth = 10.px2dp()
        paint.strokeCap = Paint.Cap.BUTT
        canvas.drawLine(50f, 50f, 400f, 50f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(50f, 150f, 400f, 150f, paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawLine(50f, 250f, 400f, 250f, paint)


        canvas.save()

        paint.reset()
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE
        path.moveTo(0f,300f)
        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)


        canvas.translate(100f, 100f)
        paint.strokeJoin = Paint.Join.MITER
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.BEVEL
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.ROUND
        canvas.drawPath(path, paint)
        canvas.restore()



        paint.reset()
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE
        path1.moveTo(0f,600f)
        path1.rLineTo(200f, 0f)
        path1.rLineTo(-160f, 120f)


        canvas.translate(100f, 100f)
        paint.strokeMiter = 1.px2dp()
        canvas.drawPath(path1, paint)

        canvas.translate(300f, 0f)
        paint.strokeMiter = 3.px2dp()
        canvas.drawPath(path1, paint)

        canvas.translate(300f, 0f)
        paint.strokeMiter = 20.px2dp()
        canvas.drawPath(path1, paint)


    }
}