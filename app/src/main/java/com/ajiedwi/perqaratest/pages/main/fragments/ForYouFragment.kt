package com.ajiedwi.perqaratest.pages.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ajiedwi.perqaratest.databinding.FragmentForYouBinding
import com.ajiedwi.perqaratest.extensions.hideKeyboard
import com.ajiedwi.perqaratest.extensions.showToast
import com.ajiedwi.perqaratest.pages.detail.DetailActivity
import com.ajiedwi.perqaratest.pages.main.MainViewModel
import com.ajiedwi.perqaratest.pages.main.adapter.GameAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForYouFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ForYouFragment()
    }

    private lateinit var adapter: GameAdapter
    private lateinit var viewBinding: FragmentForYouBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentForYouBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectFlow()
        initView()
        viewModel.fetchGameList()
    }

    private fun initView(){
        adapter = GameAdapter(requireContext()) {
            val i = Intent(requireContext(), DetailActivity::class.java)
            i.putExtra("EXTRA_ID", it.id)
            startActivity(i)
        }
        with(viewBinding){
            rvGames.adapter = adapter
            btnLoadMore.setOnClickListener {
                viewModel.gamesListRequest.page+=1
                viewModel.fetchGameList()
            }
            etSearch.setOnKeyListener { view, keyCode, keyEvent ->
                if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    (requireActivity() as AppCompatActivity).hideKeyboard(view)
                    viewModel.gamesListRequest.keyword = etSearch.text.toString()
                    viewModel.gamesListRequest.page = 1
                    viewModel.fetchGameList()
                    return@setOnKeyListener true
                }
                false
            }
        }
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            viewModel.gameListFlow.collect {
                adapter.addItems(it.results, clear = viewModel.gamesListRequest.page==1)
                viewBinding.btnLoadMore.isVisible = !it.isLast
            }
        }
        lifecycleScope.launch {
            viewModel.isLoadingFlow.collect {
                with(viewBinding){
                    if (it) btnLoadMore.isVisible = false
                    tvLoading.isVisible = it
                    rvGames.isVisible = viewModel.gamesListRequest.page!=1 || (!it && viewModel.gamesListRequest.page==1)
                }
            }
        }
    }
}