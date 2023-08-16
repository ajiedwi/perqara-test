package com.ajiedwi.data.games.implementation.diffutil

import com.ajiedwi.data.games.api.model.Game
import org.junit.Test

class GameDiffTest {

    @Test
    fun `test areItemsTheSame`(){
        val diffCallback = GameDiffCallback
        val firstGame = Game(id = 1)
        val secondGame = Game(id = 2)
        val areItemsTheSame = diffCallback.areItemsTheSame(firstGame, secondGame)
        assert(!areItemsTheSame)
    }

    @Test
    fun `test areContentsTheSame`(){
        val diffCallback = GameDiffCallback
        val firstGame = Game(id = 1)
        val secondGame = Game(id = 2)
        val areContentsTheSame = diffCallback.areContentsTheSame(firstGame, secondGame)
        assert(!areContentsTheSame)
    }

}