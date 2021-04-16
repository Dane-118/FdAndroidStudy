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
 * 描述：自定义 View 1-2 Paint 详解
 * @author fangdongdong
 * @date   2021/4/13 16:38
 */
class StudyActivity2 : AppCompatActivity() {

    private val list = arrayListOf<PageModel>(
        PageModel(R.string.title_paint_one, R.layout.stydey_paint_one),
        PageModel(R.string.title_paint_two, R.layout.stydey_paint_two),
        PageModel(R.string.title_paint_three, R.layout.stydey_paint_three),
        PageModel(R.string.title_paint_four, R.layout.stydey_paint_four),
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
            val view = View.inflate(this@StudyActivity2, list[position].sampleLayoutRes, null)
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