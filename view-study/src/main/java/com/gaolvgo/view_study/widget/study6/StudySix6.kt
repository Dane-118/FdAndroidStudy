package com.gaolvgo.view_study.widget.study6

import android.animation.TimeInterpolator
import android.content.Context
import android.graphics.Interpolator
import android.graphics.Path
import android.util.AttributeSet
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.view.animation.PathInterpolatorCompat
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp


/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/22 20:12
 */
class StudySix6(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private var animated = false
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private var translationState = 0
    private val translationStateCount = 13
    private var interpolators: Array<TimeInterpolator?> = arrayOfNulls<TimeInterpolator>(13)
    private var interpolatorPath: Path = Path()

    init {

        interpolatorPath.lineTo(0.25f, 0.25f)
        interpolatorPath.moveTo(0.25f, 1.5f)
        interpolatorPath.lineTo(1f, 1f)
        interpolators[0] = AccelerateDecelerateInterpolator()
        interpolators[1] = LinearInterpolator()
        interpolators[2] = AccelerateInterpolator()
        interpolators[3] = DecelerateInterpolator()
        interpolators[4] = AnticipateInterpolator()
        interpolators[5] = OvershootInterpolator()
        interpolators[6] = AnticipateOvershootInterpolator()
        interpolators[7] = BounceInterpolator()
        interpolators[8] = CycleInterpolator(0.5f)
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath)
        interpolators[10] = FastOutLinearInInterpolator()
        interpolators[11] = FastOutSlowInInterpolator()
        interpolators[12] = LinearOutSlowInInterpolator()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.animateBt)

        button.setOnClickListener {
            Toast.makeText(context, "${translationState}", Toast.LENGTH_SHORT).show()
            if (!animated) {
                imageView.animate()
                    .translationY(500.px2dp())
                    .setInterpolator(interpolators[translationState])
                    .duration = 600
            } else {
                imageView.animate()
                    .translationY(0f)
                    .setInterpolator(interpolators[translationState])
                    .duration = 600
                translationState += 1
                if (translationState == translationStateCount) {
                    translationState = 0
                }
            }
            animated = !animated
        }
    }


}