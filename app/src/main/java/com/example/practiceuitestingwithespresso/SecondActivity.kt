package com.example.practiceuitestingwithespresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.practiceuitestingwithespresso.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}

/** 1. When you need to press the back button, copy this :

 * Note: it will automatically destroy your activity.

    onBackPressedDispatcher.onBackPressed()

 * 2. When you need to handle the back button pressed

    onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
    println("Back button pressed")
    Toast.makeText(this@SecondActivity, "back button pressed", Toast.LENGTH_SHORT).show()
    finish()
        }
    })
 **/