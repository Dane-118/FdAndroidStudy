package com.gaolvgo.view_study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/14 10:45
 */
class StudyTextOne(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val pathEffect = CornerPathEffect(20.px2dp())

    private val heightSpan = 50.px2dp()
    private val text = "Hello World"

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.textSize = 30.px2dp()
        canvas.drawText(text, heightSpan, heightSpan, paint)

        paint.style = Paint.Style.STROKE

        path.moveTo(0f, heightSpan)
        path.lineTo(heightSpan, heightSpan * 2)
        path.lineTo(heightSpan * 2, heightSpan)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)

        paint.reset()
        paint.textSize = 20.px2dp()
        paint.style = Paint.Style.FILL
        canvas.drawTextOnPath(text, path, 0f, 0f, paint)


        /*StaticLayout 的构造方法是
        StaticLayout(CharSequence source, TextPaint paint,
         int width, Layout.Alignment align, float spacingmult,
          float spacingadd, boolean includepad)，其中参数里：
            width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
            align 是文字的对齐方向；
            spacingmult 是行间距的倍数，通常情况下填 1 就好；
            spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
            includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界*/
        val text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        textPaint.textSize = 30.px2dp()
        val staticLayout = StaticLayout(
            text1, textPaint,
            width, Layout.Alignment.ALIGN_NORMAL,
            1f, 0f, true
        )
        canvas.save()
        canvas.translate(0f, heightSpan * 2)
        staticLayout.draw(canvas)
        canvas.restore()



    }
}