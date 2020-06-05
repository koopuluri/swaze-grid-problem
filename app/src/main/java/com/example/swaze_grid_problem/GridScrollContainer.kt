package com.example.storemob.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class GridScrollContainer(context: Context, attrs: AttributeSet?, defStyleAttr: Int): ScrollView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context): this(context, null, 0)

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
    }

    init {
        setBackgroundColor(context.resources.getColor(android.R.color.transparent))
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return when (ev!!.action) {
            MotionEvent.ACTION_DOWN -> {
                return super.onTouchEvent(ev)
            }
            MotionEvent.ACTION_MOVE -> {
                return super.onTouchEvent(ev)
            }
            MotionEvent.ACTION_UP -> {
                return super.onTouchEvent(ev)
            }
            else -> super.onTouchEvent(ev)
        }
    }
}