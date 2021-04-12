package com.gaolvgo.view_study.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gaolvgo.view_study.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_view_study_1_1?.setOnClickListener {
            startActivity(Intent(this,StudyActivity1::class.java))
        }

    }
}
