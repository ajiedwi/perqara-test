package com.ajiedwi.perqaratest.pages.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ajiedwi.data.games.api.model.Game
import com.ajiedwi.data.games.implementation.diffutil.GameDiffCallback
import com.ajiedwi.perqaratest.R
import com.ajiedwi.perqaratest.databinding.ItemGamesBinding
import com.ajiedwi.perqaratest.extensions.getDimensInt
import com.ajiedwi.perqaratest.extensions.loadImage
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class GameAdapter(
    private val context: Context,
    private val onItemClicked: ((Game) -> Unit),
) : ListAdapter<Game, GameAdapter.ViewHolder>(
    GameDiffCallback
) {

    private val mItems = mutableListOf<Game>()
    fun addItems(items: List<Game>, clear: Boolean = false){
        if (clear) mItems.clear()
        mItems.addAll(items)
        submitList(mItems.toList())
    }

    inner class ViewHolder(
        private val binding: ItemGamesBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Game){
            with(binding) {
                val options = RequestOptions().transform(CenterCrop(), RoundedCorners(context.getDimensInt(R.dimen.radius_sm)))
                iv.loadImage(context, item.backgroundImage, options)
                tvTitle.text = item.name
                tvRating.text = item.rating.toString()
                tvReleaseDate.text = context.getString(R.string.release_date_placeholder,item.released)
                root.setOnClickListener { onItemClicked.invoke(item) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

}