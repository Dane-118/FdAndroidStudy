package com.gaolvgo.view_study.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.utils.px2dp


/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/14 10:44
 */
class StudyPaintFour(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    }
    private val path = Path()
    private val dashPath = Path()

    private val heightSpan = 80.px2dp()
    private val radius = 60.px2dp()
    private lateinit var pathEffect: PathEffect

    init {
        paint.strokeWidth = 3.px2dp()
        dashPath.addRect(0f, 0f, 2.px2dp(), 5.px2dp(), Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
//        path.addCircle(width / 2f, height / 2f, heightSpan, Path.Direction.CCW)
        path.addArc(
            width / 2f - heightSpan, height / 2f - heightSpan,
            width / 2f + heightSpan, height / 2f + heightSpan,
            0f, 360f
        )

        pathEffect = PathDashPathEffect(
            dashPath, 40f, 0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        canvas.drawPath(path, paint)


        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null

        paint.reset()
        paint.setShadowLayer(10f, 0f, 0f, Color.RED)
        paint.textSize = 120f
        canvas.drawText("Hello HenCoder", 50f, 200f, paint)




    }
}