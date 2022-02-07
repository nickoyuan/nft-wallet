package com.example.jetpackproject.util

import android.graphics.drawable.Drawable
import android.R
import android.content.Context

import androidx.swiperefreshlayout.widget.CircularProgressDrawable


class Util {

    companion object {
        fun circularDrawable(context: Context): Drawable {
            val drawable = CircularProgressDrawable(context)
            drawable.setColorSchemeColors(
                R.color.holo_blue_light,
                R.color.holo_green_dark,
                R.color.system_accent1_0
            )
            drawable.centerRadius = 30f
            drawable.strokeWidth = 5f
            drawable.start()
            return drawable
        }
    }
}