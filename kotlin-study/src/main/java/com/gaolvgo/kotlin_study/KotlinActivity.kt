package com.gaolvgo.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        val sequence = sequenceOf(1, 2, 3, 4)
        val result: Sequence<Int> = sequence
            .map { i ->
                println("Map $i")
                i * 2
            }
            .filter { i ->
                println("Filter $i")
                i % 3 == 0
            }
        println(result.first())

    }

    fun <T> fill(array: Array<in T>, from: T) {
        array[0] = from
    }

    fun <T> copy(from: Array<out T>, to: Array<in T>) {
        assert(from.size == to.size)
        for (i in from.indices) {
            to[i] = from[i]
        }
    }

}
