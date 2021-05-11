package com.gaolvgo.view_study.widget.study7

import android.animation.*
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.gaolvgo.view_study.R


/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/28 14:12
 */
class StudySeven1(context: Context?, val attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private lateinit var view: View
    private lateinit var bar: ProgressBar
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        view = findViewById(R.id.imageView)
        bar = findViewById(R.id.progress_Bar)
        button = findViewById(R.id.animateBt)
        button2 = findViewById(R.id.animateBt2)
        button3 = findViewById(R.id.animateBt3)

        button.setOnClickListener {
            val animator = ObjectAnimator.ofInt(
                view,
                "backgroundColor",
                -0xffff01,
                -0x10000,
                Color.GREEN,
                Color.YELLOW
            )
            animator.setEvaluator(HsvEvaluator())
            animator.interpolator = LinearInterpolator()
            animator.duration = 2000
            animator.start()
        }

        button2.setOnClickListener {
            val holder1 = PropertyValuesHolder.ofFloat("scaleX", 0f)
            val holder2 = PropertyValuesHolder.ofFloat("scaleY", 0f)
            val holder3 = PropertyValuesHolder.ofFloat("alpha", 0f)

            val holder4 = PropertyValuesHolder.ofFloat("scaleX", 1f)
            val holder5 = PropertyValuesHolder.ofFloat("scaleY", 1f)
            val holder6 = PropertyValuesHolder.ofFloat("alpha", 1f)

            val animator = ObjectAnimator.ofPropertyValuesHolder(view, holder1, holder2, holder3)
            animator.duration = 2000
            val animator2 = ObjectAnimator.ofPropertyValuesHolder(view, holder4, holder5, holder6)
            animator2.duration = 2000
            val animatorSet = AnimatorSet()
//            animatorSet.playSequentially(animator,animator2)
//            animatorSet.play(animator).before(animator2)
            animatorSet.play(animator2).after(animator)
            animatorSet.start()
        }


        button3.setOnClickListener {
            val keyframe1 = Keyframe.ofFloat(0f, 0f)
            val keyframe2 = Keyframe.ofFloat(0.5f, 100f)
            val keyframe3 = Keyframe.ofFloat(1f, 80f)
            val holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3)
            val animator = ObjectAnimator.ofPropertyValuesHolder(bar,holder)
            animator.duration = 2000

            animator.start()
        }


    }


    private class HsvEvaluator : TypeEvaluator<Int> {
        var startHsv = FloatArray(3)
        var endHsv = FloatArray(3)
        var outHsv = FloatArray(3)
        override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue, startHsv)
            Color.colorToHSV(endValue, endHsv)

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360f
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360f
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
            if (outHsv[0] > 360) {
                outHsv[0] -= 360f
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360f
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction

            // 计算当前动画完成度（fraction）所对应的透明度
            val alpha =
                startValue shr 24 + ((endValue shr 24 - startValue shr 24) * fraction).toInt()

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv)
        }
    }


}