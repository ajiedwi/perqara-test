package com.ajiedwi.perqaratest.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(
    activity: AppCompatActivity,
    private val listFragments: List<Fragment>,
) : FragmentStateAdapter(activity){

    override fun getItemCount() = listFragments.size

    override fun createFragment(position: Int) = listFragments[position]

}