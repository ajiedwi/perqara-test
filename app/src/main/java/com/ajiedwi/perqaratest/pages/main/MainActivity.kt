package com.ajiedwi.perqaratest.pages.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.ActivityMainBinding
import com.ajiedwi.perqaratest.pages.main.fragments.ForYouFragment
import com.ajiedwi.perqaratest.pages.main.fragments.YourFavouriteFragment
import com.ajiedwi.perqaratest.utils.MainPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()
    }

    private fun initView(){
        with(viewBinding){
            vpMain.adapter = MainPagerAdapter(
                activity = this@MainActivity,
                listFragments = listOf(
                    ForYouFragment.newInstance(),
                    YourFavouriteFragment.newInstance()
                )
            )
            vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    with(viewBinding){
                        hbbMain.active = position
                    }
                }
            })

            hbbMain.onMenuClicked = { pos ->
                vpMain.currentItem = pos
            }
        }
    }
}