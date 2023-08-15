package com.ajiedwi.perqaratest.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.CustomToolbarBinding
import com.ajiedwi.perqaratest.databinding.HomeBottombarBinding
import com.ajiedwi.perqaratest.databinding.HomeMenuBinding
import com.ajiedwi.perqaratest.extensions.loadImage
import com.ajiedwi.perqaratest.extensions.showToast
import com.bumptech.glide.Glide

class HomeBottomBar: LinearLayoutCompat {

    var active = 0
        set(value) {
            field = value
            with(viewBinding){
                hmForYou.isActive = value == 0
                hmYourFavourite.isActive = value == 1
            }
        }

    var onMenuClicked: ((Int) -> Unit) = {}

    private var viewBinding = HomeBottombarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)

    init {
        with(viewBinding){
            hmForYou.setOnClickListener {
                onMenuClicked.invoke(0)
            }
            hmYourFavourite.setOnClickListener {
                onMenuClicked.invoke(1)
            }
        }
    }
}