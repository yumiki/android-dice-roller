package com.dolu.badge.diceroller.model

class Dice(val color: String, private val sides: Int = 6) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
