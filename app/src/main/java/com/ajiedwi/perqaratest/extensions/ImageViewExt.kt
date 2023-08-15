package com.ajiedwi.perqaratest.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(context: Context, url: String) {
    Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true).into(this)
}

fun ImageView.loadImage(context: Context, url: String, options: RequestOptions) {
    Glide.with(context).load(url).apply(options).diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true).into(this)
}

fun ImageView.loadImage(context: Context, @DrawableRes img: Int) {
    Glide.with(context).load(img).into(this)
}

fun ImageView.loadImage(context: Context, img: Drawable) {
    Glide.with(context).load(img).into(this)
}

fun ImageView.setTint(colorId: Int) = this.setColorFilter(this.context.getColor(colorId))