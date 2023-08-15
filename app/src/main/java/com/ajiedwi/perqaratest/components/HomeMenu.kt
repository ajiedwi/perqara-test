package com.ajiedwi.perqaratest.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.HomeMenuBinding
import com.ajiedwi.perqaratest.extensions.getFont
import com.ajiedwi.perqaratest.extensions.loadImage
import com.ajiedwi.perqaratest.extensions.setTint
import com.ajiedwi.perqaratest.extensions.showToast

class HomeMenu: LinearLayoutCompat {

    var title = ""
        set(value) {
            field = value
            with(viewBinding.tvTitle){
                text = value
                isVisible = value.isNotEmpty()
            }
        }

    var icon: Drawable? = null
        set(value) {
            field = value
            with(viewBinding.ivIcon){
                if (value!=null) this.loadImage(context, value)
                isVisible = value!=null
            }
        }

    var isActive = false
        set(value) {
            field = value
            with(viewBinding){
                ivIcon.setTint(if (value) R.color.fiord else R.color.silver_chalice)
                tvTitle.setTextColor(context.getColor(if (value) R.color.fiord else R.color.silver_chalice))
                tvTitle.typeface = context.getFont(if (value) R.font.poppins_bold else R.font.poppins_reguler)
            }
        }

    private var viewBinding = HomeMenuBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.HomeMenu,0, 0)
        with(viewBinding) {
            try {

                title = typedArray.getString(R.styleable.HomeMenu_hm_title) ?: ""
                icon = typedArray.getDrawable(R.styleable.HomeMenu_hm_icon)
                isActive = typedArray.getBoolean(R.styleable.HomeMenu_hm_is_active, false)

            } finally {
                typedArray.recycle()
            }
        }
    }
}