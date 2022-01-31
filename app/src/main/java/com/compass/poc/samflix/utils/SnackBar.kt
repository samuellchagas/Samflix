package com.compass.poc.samflix.utils

import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.snackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(this, message, duration)
        .setBackgroundTint(Color.parseColor("#FF1616"))
        .show()
}
