package com.gaolvgo.view_study.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/12 16:31
 */
class StudyDrawColor(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        this.isAntiAlias = true
        this.style = Paint.Style.FILL_AND_STROKE
    }

    private val path = Path()
    private val path2 = Path()
    private val path3 = Path()
    private val path4 = Path()
    private val radius = 60.px2dp()
    private val heightSpan = 80.px2dp()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.addCircle(width / 2f - radius / 2F, heightSpan, radius, Path.Direction.CW)
        path.addCircle(width / 2f + radius / 2F, heightSpan, radius, Path.Direction.CCW)

        path2.addCircle(width / 2f - radius / 2F, heightSpan * 3, radius, Path.Direction.CCW)
        path2.addCircle(width / 2f + radius / 2F, heightSpan * 3, radius, Path.Direction.CCW)

        path3.addArc(
            width / 2f - radius,
            heightSpan * 4,
            width / 2f,
            heightSpan * 4 + radius,
            -225f, 225f
        )
        path3.arcTo(
            width / 2f,
            heightSpan * 4,
            width / 2f + radius,
            heightSpan * 4 + radius,
            180f, 225f, false
        )
        path3.lineTo(width / 2f, heightSpan  * 4+ radius * 1.7f)


        path4.addCircle(width / 2f,heightSpan * 7,heightSpan,Path.Direction.CCW)
        path4.addCircle(width / 2f,heightSpan * 7,radius,Path.Direction.CCW)
        path4.fillType = Path.FillType.EVEN_ODD // WINDING 是「全填充」，而 EVEN_ODD 是「交叉填充」
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)


        canvas.drawPath(path, paint)


        canvas.drawPath(path2, paint)

        canvas.drawPath(path3, paint)

        canvas.drawPath(path4, paint)

    }
}