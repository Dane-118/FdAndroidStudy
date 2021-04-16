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
 * @date   2021/4/14 10:45
 */
class StudyPaintOne(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    }

    private val heightSpan = 80.px2dp()
    private val heightSpanInt = 60.px2dpInt()
    private val radius = 60.px2dp()

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient ；颜色：#E91E63 到 #2196F3
        /*构造方法：
            LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile) 。
            参数：
            x0 y0 x1 y1：渐变的两个端点的位置
            color0 color1 是端点的颜色
            tile：端点范围之外的着色规则，类型是 TileMode。
            TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。
            CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；
            MIRROR 是镜像模式；REPEAT 是重复模式*/
        val share = LinearGradient(
            width / 2f - radius,
            heightSpan - radius,
            width / 2f + radius,
            heightSpan + radius,
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.CLAMP
        )
        paint.shader = share
        canvas.drawCircle(width / 2f, heightSpan, radius, paint)


        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 颜色：#E91E63 到 #2196F3
        /*构造方法：
            RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)。
            参数：
            centerX centerY：辐射中心的坐标
            radius：辐射半径
            centerColor：辐射中心的颜色
            edgeColor：辐射边缘的颜色
            tileMode：辐射范围之外的着色模式。
            */
        val radialGradient = RadialGradient(
            width / 2f,
            heightSpan * 3,
            radius,
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.CLAMP
        )
        paint.shader = radialGradient
        canvas.drawCircle(width / 2f, heightSpan * 3, radius, paint)

        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient ；颜色：#E91E63 到 #2196F3
        /*构造方法：
        SweepGradient(float cx, float cy, int color0, int color1)
        参数：
        cx cy ：扫描的中心
        color0：扫描的起始颜色
        color1：扫描的终止颜色
         */
        val sweepGradient = SweepGradient(
            width / 2f, heightSpan * 5, Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3")
        )
        paint.shader = sweepGradient
        canvas.drawCircle(width / 2f, heightSpan * 5, radius, paint)

        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
        paint.reset()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
        paint.shader = bitmapShader
        canvas.drawCircle(width / 2f, heightSpan * 7, radius, paint)
        canvas.drawCircle(200f, 200f, 200f, paint)


    }
}