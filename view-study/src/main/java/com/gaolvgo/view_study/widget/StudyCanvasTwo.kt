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
 * @date   2021/5/10 13:54
 */
class StudyCanvasTwo(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var heightSpan = 100.px2dp()
    private val widthBitmap = 100.px2dp()
    private val bitmapWidth = 200.px2dpInt()

    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    private var bitmap1: Bitmap = getAvatar(bitmapWidth)
    private val camera = Camera()

    init {
        camera.rotateX(30f)
        camera.setLocation(0f,0f,-13f)
    }


    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(heightSpan + bitmap.width / 2, heightSpan + bitmap.height / 2)
        camera.applyToCanvas(canvas)
        canvas.translate(-(heightSpan + bitmap.width / 2), -(heightSpan + bitmap.height / 2))
        canvas.drawBitmap(bitmap, heightSpan, heightSpan, paint)
        canvas.restore()

        heightSpan = height / 2f
        //上半部分
        canvas.save()
        canvas.translate(widthBitmap + bitmapWidth / 2, heightSpan + bitmapWidth / 2)
        canvas.rotate(-30f)
        canvas.clipRect(-bitmapWidth, -bitmapWidth, bitmapWidth, 0)
        canvas.rotate(30f)
        canvas.translate(-(widthBitmap + bitmapWidth / 2), -(heightSpan + bitmapWidth / 2))
        canvas.drawBitmap(bitmap1, widthBitmap, heightSpan, paint)
        canvas.restore()

        //下半部分
        canvas.save()
        canvas.translate(widthBitmap + bitmapWidth / 2, heightSpan + bitmapWidth / 2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-bitmapWidth, 0, bitmapWidth, bitmapWidth)
        canvas.rotate(30f)
        canvas.translate(-(widthBitmap + bitmapWidth / 2), -(heightSpan + bitmapWidth / 2))
        canvas.drawBitmap(bitmap1, widthBitmap, heightSpan, paint)
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