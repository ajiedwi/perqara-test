package com.ajiedwi.perqaratest.extensions

import android.content.Context
import android.graphics.Typeface
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.showToast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, message, duration).show()
}

fun Context.getColor(id: Int) = ContextCompat.getColor(this, id)

fun Context.getDimensInt(id: Int): Int = resources.getDimension(id).toInt()

fun Context.getFont(font: Int): Typeface? {
    return ResourcesCompat.getFont(this, font)
}