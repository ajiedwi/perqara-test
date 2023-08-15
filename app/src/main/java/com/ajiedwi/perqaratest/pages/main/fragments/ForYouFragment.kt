package com.ajiedwi.perqaratest.pages.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ajiedwi.perqaratest.databinding.FragmentForYouBinding

class ForYouFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = ForYouFragment()
    }

    private lateinit var viewBinding: FragmentForYouBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentForYouBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}