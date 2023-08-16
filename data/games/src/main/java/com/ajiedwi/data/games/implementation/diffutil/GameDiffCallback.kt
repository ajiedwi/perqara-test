package com.ajiedwi.data.games.implementation.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.ajiedwi.data.games.api.model.Game

object GameDiffCallback: DiffUtil.ItemCallback<Game>() {

    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem == newItem
}
