package com.example.storemob.views.com.example.swaze_grid_problem

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.widget.RelativeLayout
import com.example.storemob.UTIL

private const val GRID_LINE_WIDTH = 6f

class TheGrid(
    context: Context
): View(context) {

    val gridLinesPaint = UTIL.getPaint(Color.parseColor("#000000"), GRID_LINE_WIDTH, Paint.Style.STROKE)
    val gridFillPaint = UTIL.getPaint(Color.parseColor("#ffffff"), 0f, Paint.Style.FILL)

    init {
        layoutParams = RelativeLayout.LayoutParams(
            UTIL.numCols * UTIL.cellWidthPixels + UTIL.marginWidth * 2,
            UTIL.numRows * UTIL.cellWidthPixels
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        println("klas;jfkl;adsjfkl;jsadkl;jfkl;adsjfkl;ajsd;lfjadkls;jfl;ajsl;fjlak;DJ drawing the grid: " + UTIL.numCols + " rows; " + UTIL.numRows + " cellWidth: " + UTIL.cellWidthPixels)

        // drawing the grid:
        for (x in 0 until UTIL.numRows) {
            for (y in 0 until UTIL.numCols) {
                val gridRect = Rect(
                    y*UTIL.cellWidthPixels + UTIL.marginWidth,
                    x*UTIL.cellWidthPixels,
                    (y+1) * UTIL.cellWidthPixels + UTIL.marginWidth,
                    (x+1) * UTIL.cellWidthPixels
                )
                canvas.drawRect(gridRect, gridLinesPaint)
                canvas.drawRect(gridRect, gridFillPaint)
            }
        }
    }
}