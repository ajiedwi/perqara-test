package com.ajiedwi.perqaratest.pages.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.ActivityDetailBinding
import com.ajiedwi.perqaratest.databinding.ActivityMainBinding
import com.ajiedwi.perqaratest.pages.main.fragments.ForYouFragment
import com.ajiedwi.perqaratest.pages.main.fragments.YourFavouriteFragment
import com.ajiedwi.perqaratest.utils.MainPagerAdapter

class DetailActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()
    }

    private fun initView(){
        with(viewBinding){
            toolbar.onBackButtonClicked = {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}