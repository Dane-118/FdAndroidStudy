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
 * @date   2021/4/14 10:44
 */
class StudyPaintTwo(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    }

    private val heightSpan = 80.px2dp()
    private val heightSpanInt = 60.px2dpInt()
    private val radius = 60.px2dp()

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val shaderBitmap1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shaderBitmap2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val composeShader = ComposeShader(shaderBitmap1, shaderBitmap2, PorterDuff.Mode.DST_IN)
        paint.shader = composeShader
        canvas.drawCircle(200f, 200f, 200f, paint)

        canvas.drawBitmap(bitmap1, width / 2f, 0f, paint)


        val lightingColorFilter = LightingColorFilter(0x00ffff, 0x000000)
        paint.colorFilter = lightingColorFilter
        canvas.drawBitmap(bitmap1, 100f, heightSpan * 2, paint)

        val matrix = ColorMatrix()
        matrix.setSaturation(11f)
        val colorMatrixColorFilter = ColorMatrixColorFilter(matrix)
        paint.colorFilter = colorMatrixColorFilter
        canvas.drawBitmap(bitmap1, width / 2f, heightSpan * 2, paint)


        paint.reset()
        val saved = canvas.saveLayer(null, paint)
        canvas.drawBitmap(bitmap1, 100f, heightSpan * 4, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas.drawBitmap(bitmap2, 100f, heightSpan * 4, paint)
        paint.xfermode = null

        canvas.restoreToCount(saved)
    }
}