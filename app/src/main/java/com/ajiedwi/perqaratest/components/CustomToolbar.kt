package com.ajiedwi.perqaratest.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.CustomToolbarBinding
import com.ajiedwi.perqaratest.extensions.loadImage
import com.ajiedwi.perqaratest.extensions.showToast

class CustomToolbar: LinearLayoutCompat {

    var title = ""
        set(value) {
            field = value
            with(viewBinding.tvTitle){
                text = value
                isVisible = value.isNotEmpty()
            }
        }

    var showBackButton = false
        set(value) {
            field = value
            with(viewBinding.ivBackButton){
                isVisible = value
            }
        }

    var rightIcon: Drawable? = null
        set(value) {
            field = value
            with(viewBinding.ivRightIcon){
                if (value!=null) this.setImageDrawable(value)
                isVisible = value!=null
            }
        }

    lateinit var onBackButtonClicked: (() -> Unit)
    lateinit var onRightIconClicked: (() -> Unit)

    private var viewBinding = CustomToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomToolbar,0, 0)
        with(viewBinding) {
            try {

                title = typedArray.getString(R.styleable.CustomToolbar_ct_title) ?: ""
                showBackButton = typedArray.getBoolean(R.styleable.CustomToolbar_ct_show_back_button, false)
                rightIcon = typedArray.getDrawable(R.styleable.CustomToolbar_ct_right_icon)


            } finally {
                typedArray.recycle()
            }

            ivBackButton.setOnClickListener {
                if (this@CustomToolbar::onBackButtonClicked.isInitialized) onBackButtonClicked.invoke()
                else context.showToast("Not Implemented Yet!")
            }
            ivRightIcon.setOnClickListener {
                if (this@CustomToolbar::onRightIconClicked.isInitialized) onRightIconClicked.invoke()
                else context.showToast("Not Implemented Yet!")
            }
        }
    }
}