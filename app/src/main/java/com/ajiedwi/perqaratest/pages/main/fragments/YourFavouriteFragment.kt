package com.ajiedwi.perqaratest.pages.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ajiedwi.perqaratest.databinding.FragmentForYouBinding
import com.ajiedwi.perqaratest.databinding.FragmentYourFavouriteBinding

class YourFavouriteFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = YourFavouriteFragment()
    }

    private lateinit var viewBinding: FragmentYourFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentYourFavouriteBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}