package com.gaolvgo.view_study.utils

import android.content.res.Resources
import android.util.TypedValue
import androidx.core.content.res.TypedArrayUtils

/**
 * 描述：
 * @author fangdongdong
 * @date   2021/4/12 17:43
 */

fun Int.px2dp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )
}

fun Int.px2dpInt(): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()
}