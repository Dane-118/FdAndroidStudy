package com.example.room_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.room_study.dao.DaoManager
import com.example.room_study.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num = 0
        DaoManager.getInstance(this)?.appDatabase

        get_all?.setOnClickListener {
            GlobalScope.launch {
                val list = DaoManager.getInstance(applicationContext)?.userDao?.all
                list?.forEach {
                    Log.d(Companion.TAG, "onCreate: ${it.toString()}")
                }
            }

        }

        add?.setOnClickListener {
            val user = User("hell word ${num}","你好 ${num}")
            GlobalScope.launch {
                DaoManager.getInstance(applicationContext)?.userDao?.insertAll(user)
            }

            num++
        }

        del?.setOnClickListener {

        }

        update?.setOnClickListener {

        }

        clear?.setOnClickListener {
            GlobalScope.launch {
                DaoManager.getInstance(applicationContext)?.userDao?.deleteAll()
            }

        }

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
