package com.ajiedwi.perqaratest.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.CustomToolbarBinding
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

    lateinit var onBackButtonClicked: (() -> Unit)

    private var viewBinding = CustomToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomToolbar,0, 0)
        with(viewBinding) {
            try {

                title = typedArray.getString(R.styleable.CustomToolbar_ct_title) ?: ""
                showBackButton = typedArray.getBoolean(R.styleable.CustomToolbar_ct_show_back_button, false)

            } finally {
                typedArray.recycle()
            }

            ivBackButton.setOnClickListener {
                if (this@CustomToolbar::onBackButtonClicked.isInitialized) onBackButtonClicked.invoke()
                else context.showToast("Not Implemented Yet!")
            }
        }
    }
}