package com.example.senior

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Restore the click count from the saved instance state (if available)
        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT, 0)
        }

        updateClickCountTextView()

        findViewById<Button>(R.id.increaseButton).setOnClickListener {
            clickCount++
            updateClickCountTextView()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CLICK_COUNT, clickCount)
    }

    private fun updateClickCountTextView() {
        findViewById<TextView>(R.id.clickCountTextView).text = "Click Count: $clickCount"
    }

    companion object {
        private const val KEY_CLICK_COUNT = "click_count"
    }
}

