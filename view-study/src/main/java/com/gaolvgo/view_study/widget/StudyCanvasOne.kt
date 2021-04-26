package com.gaolvgo.view_study.widget

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
class StudyCanvasOne(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val radius = 80.px2dp()
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val path1 = Path()
    private val path2 = Path()
    private var heightSpan = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        heightSpan = bitmap.width.toFloat()
        path1.addCircle(
            heightSpan * 2,
            heightSpan * 2 - 20.px2dp(),
            heightSpan - 50.px2dp(),
            Path.Direction.CW
        )
        path2.fillType = Path.FillType.INVERSE_WINDING
        val str = ""

    }

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.clipRect(30f, 30f, bitmap.width - 30f, bitmap.height - 50.px2dp())
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, heightSpan, heightSpan, paint)
        canvas.restore()

        val matrix = matrix
        canvas.save()
        matrix.reset()
        matrix.postTranslate((100).px2dp(), (100).px2dp())
        canvas.concat(matrix)
//        canvas.translate((100).px2dp(), (100).px2dp())
        canvas.drawBitmap(bitmap, 0f, 300.px2dp(), paint)
        canvas.restore()


    }
}