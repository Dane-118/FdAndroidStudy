package com.gaolvgo.view_study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/14 10:45
 */
class StudyTextTwo(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val fontMetrics = Paint.FontMetrics()

    private val heightSpan = 100.px2dp()
    val text =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tristique urna tincidunt maximus viverra. Maecenas commodo pellentesque dolor ultrices porttitor. Vestibulum in arcu rhoncus, maximus ligula vel, consequat sem. Maecenas a quam libero. Praesent hendrerit ex lacus, ac feugiat nibh interdum et. Vestibulum in gravida neque. Morbi maximus scelerisque odio, vel pellentesque purus ultrices quis. Praesent eu turpis et metus venenatis maximus blandit sed magna. Sed imperdiet est semper urna laoreet congue. Praesent mattis magna sed est accumsan posuere. Morbi lobortis fermentum fringilla. Fusce sed ex tempus, venenatis odio ac, tempor metus."

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bitmap = getAvatar(100.px2dpInt())
        canvas.drawBitmap(bitmap, width - heightSpan, heightSpan, paint)
        paint.textSize = 20.px2dp()
        paint.getFontMetrics(fontMetrics)
        var verticalOffset = -fontMetrics.top
        val measuredWidth = floatArrayOf(0f)
        var start = 0
        var count: Int
        var maxWidth: Float
        while (start < text.length - 1) {
            maxWidth = if (verticalOffset + fontMetrics.bottom < heightSpan || verticalOffset + fontMetrics.top > heightSpan * 2) {
                    width.toFloat()
                } else {
                    width.toFloat() - heightSpan
                }
            Log.d("TAG", "onDraw: ${verticalOffset}   fontMetrics.bottom = ${fontMetrics.bottom}  fontMetrics.top = ${fontMetrics.top}  heightSpan = ${heightSpan}")

            count = paint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, paint)
            start += count
            verticalOffset += paint.fontSpacing
        }


    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.batman, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.batman, options)
    }

}