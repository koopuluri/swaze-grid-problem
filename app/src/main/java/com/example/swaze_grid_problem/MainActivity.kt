package com.example.swaze_grid_problem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.storemob.UTIL
import com.example.storemob.views.com.example.swaze_grid_problem.TheGrid

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UTIL.init(this)

        val root = findViewById<FrameLayout>(R.id.root)
        root.addView(TheGrid(this))
        root.addView(Boxes(this))
    }
}
