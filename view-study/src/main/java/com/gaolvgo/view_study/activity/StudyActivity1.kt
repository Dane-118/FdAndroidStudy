package com.gaolvgo.view_study.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gaolvgo.view_study.R
import com.gaolvgo.view_study.bean.PageModel
import kotlinx.android.synthetic.main.activity_study1.*

/**
 * 描述：自定义 View 1-1 绘制基础
 * @author fangdongdong
 * @date   2021/4/12 16:58
 */
class StudyActivity1 : AppCompatActivity() {

    private val list = arrayListOf<PageModel>(
        PageModel(R.string.title_draw_color, R.layout.stydey_draw_color),
        PageModel(R.string.title_draw_circle, R.layout.stydey_draw_circle)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study1)

        page1.adapter = StudyAdapter()
        tab_layout1.setupWithViewPager(page1)
    }


    inner class StudyAdapter() : PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = View.inflate(this@StudyActivity1, list[position].sampleLayoutRes, null)
            (container as ViewPager).addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            (container as ViewPager).removeView(`object` as View)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return getString(list[position].title)
        }
    }


}