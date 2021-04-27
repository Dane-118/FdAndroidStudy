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
class StudyOne6(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private var translationState = 0
    private val translationStateCount = 6

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.animateBt)

        imageView.outlineProvider = MusicOutlineProvider()

        button.setOnClickListener {
            when (translationState) {
                0 -> {
                    imageView.animate().translationX(100.px2dp())
                }
                1 -> {
                    imageView.animate().translationX(0.px2dp())
                }
                2 -> {
                    imageView.animate().translationY(100.px2dp())
                }
                3 -> {
                    imageView.animate().translationY(0.px2dp())
                }
                4 -> {
                    imageView.animate().translationZ(15.px2dp())
                }
                5 -> {
                    imageView.animate().translationZ(0.px2dp())
                }

            }
            translationState += 1
            if (translationState == translationStateCount) {
                translationState = 0
            }
        }
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    internal class MusicOutlineProvider : ViewOutlineProvider() {
        private var path: Path = Path()
        override fun getOutline(view: View, outline: Outline) {
            outline.setConvexPath(path)
        }

        init {
            path.moveTo(0f, 10.px2dp())
            path.lineTo(7.px2dp(), 2.px2dp())
            path.lineTo(116.px2dp(), 58.px2dp())
            path.lineTo(116.px2dp(), 70.px2dp())
            path.lineTo(7.px2dp(), 128.px2dp())
            path.lineTo(0f, 120.px2dp())
            path.close()
        }
    }

}