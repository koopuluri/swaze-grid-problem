package com.example.swaze_grid_problem

import android.content.Context
import android.graphics.Color
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.storemob.UTIL

class Box (var left: Int, var right: Int, var top: Int, var bottom: Int, var color: Int) {}

class Boxes(context: Context): RelativeLayout(context) {

    var boxes = arrayOf(
        Box(0, 1, 0, 2, Color.parseColor("red")),
        Box(2, 3, 4, 6, Color.parseColor("blue"))
    )

    fun draw(box: Box) {
        var params = RelativeLayout.LayoutParams(
            (box.right - box.left + 1)*UTIL.cellWidthPixels,
            (box.bottom - box.top + 1)*UTIL.cellWidthPixels
        )
        params.leftMargin = box.left*UTIL.cellWidthPixels + UTIL.marginWidth
        params.topMargin = box.top*UTIL.cellWidthPixels
        val view = TextView(context)
        view.setBackgroundColor(box.color)
        view.layoutParams = params
        addView(view)
    }

    init {
        layoutParams = LayoutParams(
            UTIL.numCols*UTIL.cellWidthPixels + UTIL.marginWidth*2,
            UTIL.numRows* UTIL.cellWidthPixels
        )

        setBackgroundColor(context.resources.getColor(android.R.color.transparent))

        boxes.map {
            draw(it)
        }
    }
}