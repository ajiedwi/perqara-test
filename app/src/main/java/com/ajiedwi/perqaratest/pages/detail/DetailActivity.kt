package com.ajiedwi.perqaratest.pages.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.ActivityDetailBinding
import com.ajiedwi.perqaratest.extensions.getDrawableInt
import com.ajiedwi.perqaratest.extensions.loadImage
import com.ajiedwi.perqaratest.extensions.toHtml
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val id by lazy { intent.getIntExtra("EXTRA_ID", 0) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        collectFlow()
        initView()
        viewModel.fetchGameDetail(gameId = id)
        viewModel.checkIsFavourite(gameId = id)
    }

    private fun initView(){
        with(viewBinding){
            toolbar.onBackButtonClicked = {
                onBackPressedDispatcher.onBackPressed()
            }
            toolbar.onRightIconClicked = {
                if (viewModel.isFavourite) viewModel.removeFromFavourite()
                else viewModel.addToFavourite()
            }
        }
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            viewModel.gameDetailFlow.collect {
                with(viewBinding){
                    ivDetail.loadImage(this@DetailActivity, it.backgroundImage)
                    tvDevelopers.text = it.developers.map { it.name }.joinToString(", ")
                    tvName.text = it.name
                    tvReleaseDate.text = getString(R.string.release_date_placeholder, it.released)
                    tvPlayed.text = getString(R.string.played_placeholder, it.playtime)
                    tvRating.text = it.rating.toString()
                    tvDescription.text = it.description.toHtml()
                }
            }
        }

        lifecycleScope.launch {
            viewModel.isFavouriteFlow.collect {
                viewBinding.toolbar.rightIcon = getDrawableInt(
                    if (it) R.drawable.ic_favourite_white
                    else R.drawable.ic_favourite_outline_white
                )
            }
        }
    }

}