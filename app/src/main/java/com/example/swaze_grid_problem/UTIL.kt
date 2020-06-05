package com.example.storemob
import android.graphics.Paint
import android.util.DisplayMetrics
import androidx.fragment.app.FragmentActivity
import kotlin.math.ceil

object UTIL {
    lateinit var activity: FragmentActivity
    const val CELL_WIDTH = 97
    var cellWidthPixels = 0
    var screenHeight = 0
    var screenWidth = 0

    val numRows = 10
    val numCols = 4
    val marginWidth = 10

    fun init(activity: FragmentActivity) {
        this.activity = activity

        // initialize cell width stuffs:
        cellWidthPixels = displayPixelsToScreenPixels(CELL_WIDTH)
        val metrics = DisplayMetrics()
        activity.windowManager?.getDefaultDisplay()?.getMetrics(metrics)
        screenHeight = metrics.heightPixels
        screenWidth = metrics.widthPixels
    }

    fun getPaint(paintColor: Int, width: Float, paintStyle: Paint.Style): Paint {
        return Paint().apply {
            color = paintColor
            // Smooths out edges of what is drawn without affecting shape.
            isAntiAlias = true
            // Dithering affects how colors with higher-precision than the device are down-sampled.
            isDither = true
            style = paintStyle // default: FILL
            strokeJoin = Paint.Join.ROUND // default: MITER
            strokeCap = Paint.Cap.ROUND // default: BUTT
            strokeWidth = width // default: Hairline-width (really thin)
        }
    }

    fun displayPixelsToScreenPixels(displayPixels: Int): Int {
        val metrics = DisplayMetrics()
        activity.windowManager?.getDefaultDisplay()?.getMetrics(metrics)
        return ceil(displayPixels * metrics.density).toInt()
    }
}