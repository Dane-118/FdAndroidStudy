package com.gaolvgo.view_study.widget.study8

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt
import androidx.core.graphics.withSave as withSave1

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/21 15:38
 */
class StudyEight2(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmapWidth = 150.px2dpInt()
    private val heightSpan = 100.px2dp()
    private val bitmap = getAvatar(bitmapWidth)
    private val camera = Camera()

    private var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    private var bottomFlip = 30f
        set(value) {
            field = value
            invalidate()
        }

    private var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {

        //上半部分
        canvas.save()
        canvas.translate(heightSpan + bitmapWidth / 2, heightSpan + bitmapWidth / 2)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-(bitmapWidth / 1f), -(bitmapWidth / 1f), bitmapWidth / 1f, 0f)
        canvas.rotate(flipRotation)
        canvas.translate(-(heightSpan + bitmapWidth / 2), -(heightSpan + bitmapWidth / 2))
        canvas.drawBitmap(bitmap, heightSpan, heightSpan, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(heightSpan + bitmapWidth / 2, heightSpan + bitmapWidth / 2)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-(bitmapWidth / 1f), 0f, bitmapWidth / 1f, bitmapWidth / 1f)
        canvas.rotate(flipRotation)
        canvas.translate(-(heightSpan + bitmapWidth / 2), -(heightSpan + bitmapWidth / 2))
        canvas.drawBitmap(bitmap, heightSpan, heightSpan, paint)
        canvas.restore()

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