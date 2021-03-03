package com.dolu.badge.diceroller.model

import kotlin.random.Random

class Coin(val material: String = "Gold") {
    fun flip(): String {
        return if(Random.nextBoolean()) "Heads" else "tails"
    }
}