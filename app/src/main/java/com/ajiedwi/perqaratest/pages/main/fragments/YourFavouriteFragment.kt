package com.ajiedwi.perqaratest.pages.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ajiedwi.perqaratest.databinding.FragmentForYouBinding
import com.ajiedwi.perqaratest.databinding.FragmentYourFavouriteBinding
import com.ajiedwi.perqaratest.pages.detail.DetailActivity
import com.ajiedwi.perqaratest.pages.main.MainViewModel
import com.ajiedwi.perqaratest.pages.main.adapter.GameAdapter
import kotlinx.coroutines.launch

class YourFavouriteFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = YourFavouriteFragment()
    }

    private lateinit var adapter: GameAdapter
    private lateinit var viewBinding: FragmentYourFavouriteBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentYourFavouriteBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        collectFlow()
    }

    private fun initView(){
        adapter = GameAdapter(requireContext()) {
            val i = Intent(requireContext(), DetailActivity::class.java)
            i.putExtra("EXTRA_ID", it.id)
            startActivity(i)
        }
        with(viewBinding){
            rvGames.adapter = adapter
        }
    }
    private fun collectFlow() {
        lifecycleScope.launch {
            viewModel.favouritesFlow.collect {
                adapter.addItems(it, clear = true)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavouriteGames()
    }
}