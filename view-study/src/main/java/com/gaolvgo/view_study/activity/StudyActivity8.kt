package com.gaolvgo.view_study.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.utils.px2dp
import com.gaolvgo.view_study.utils.px2dpInt
import kotlinx.android.synthetic.main.activity_study1.*
import kotlinx.android.synthetic.main.study_eight_1.*

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/5/11 14:06
 */
class StudyActivity8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_eight_1)

//        val animator = ObjectAnimator.ofFloat(study_eight1,"radius",100.px2dp())
//        animator.startDelay = 1000
//        animator.duration = 5000
//        animator.start()


//        topAnimator.start()

        val bottomAnimator = ObjectAnimator.ofFloat(study_eight1, "bottomFlip", 60f)
        bottomAnimator.startDelay = 1000
        bottomAnimator.duration = 5000
//        bottomAnimator.start()

        val fileAnimator = ObjectAnimator.ofFloat(study_eight1, "flipRotation", 180f)
        bottomAnimator.startDelay = 200
        bottomAnimator.duration = 5000

        val topAnimator = ObjectAnimator.ofFloat(study_eight1, "topFlip", -60f)
        topAnimator.startDelay = 200
        topAnimator.duration = 5000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomAnimator, fileAnimator, topAnimator)
        animatorSet.start()
    }
}