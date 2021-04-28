package com.gaolvgo.view_study.widget.study7

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
 * @date   2021/4/27 16:39
 */
class StudySeven1(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private var translationState = 0
    private val translationStateCount = 6

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.animateBt)

        button.setOnClickListener {
            when (translationState) {
                0 -> {
                    imageView.animate().rotation(180f)
                }
                1 -> {
                    imageView.animate().rotation(0f)
                }
                2 -> {
                    imageView.animate().rotationX(180f)
                }
                3 -> {
                    imageView.animate().rotationX(0f)
                }
                4 -> {
                    imageView.animate().rotationY(180f)
                }
                5 -> {
                    imageView.animate().rotationY(0f)
                }

            }
            translationState += 1
            if (translationState == translationStateCount) {
                translationState = 0
            }
        }
    }


}