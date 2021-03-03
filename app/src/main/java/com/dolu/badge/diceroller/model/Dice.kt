package com.dolu.badge.diceroller.model

import kotlin.random.Random

class Dice(val color: String, val sides: Int = 6) {
    fun roll(): Int {
        return (1..sides).random()
    }
}

class Coin(val material: String = "Gold") {
    fun flip(): String {
        return if(Random.nextBoolean()) "Heads" else "tails"
    }
}