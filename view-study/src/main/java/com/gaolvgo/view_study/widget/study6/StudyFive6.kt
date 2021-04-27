package com.gaolvgo.view_study.widget.study6

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp


/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/22 20:12
 */
class StudyFive6(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private var animated = false
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.animateBt)

        button.setOnClickListener {
            if (!animated) {
                imageView.animate()
                    .translationX(200.px2dp())
                    .rotation(360f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
            } else {
                imageView.animate()
                    .translationX(0f)
                    .rotation(0f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .alpha(0f)
            }
            animated = !animated
        }
    }


}