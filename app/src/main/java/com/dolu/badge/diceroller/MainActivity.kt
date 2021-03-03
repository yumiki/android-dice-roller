package com.dolu.badge.diceroller

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dolu.badge.diceroller.model.Dice

class MainActivity : AppCompatActivity() {
    private val dice = Dice("red")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            rollDice()
        }
    }

    fun scale(view: View, up: Boolean = true) {
        if (up) {
            view.animate().scaleX(1.5f).scaleY(1.5f).alpha(1.0f).duration = 5000
        } else {
            view.animate().scaleX(.5f).scaleY(.5f).alpha(.0f).duration = 2000
        }
    }


    private fun rollDice() {
        val resultTV: TextView = findViewById(R.id.textView)
        resultTV.text = dice.roll().toString()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.setDecorFitsSystemWindows(false)
        window.insetsController?.run {
            hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        window.setDecorFitsSystemWindows(true)
        window.insetsController?.run {
            show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        }
    }
}