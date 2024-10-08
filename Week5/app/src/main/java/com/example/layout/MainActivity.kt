package com.example.layout

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var buttonsVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Using ViewBinding to access UI elements
        val imageButton: ImageView = findViewById(R.id.imageView)

        imageButton.setOnClickListener{
            buttonsVisible = !buttonsVisible
            val linearLayout = findViewById<LinearLayout>(R.id.linearLayout2)
            if (buttonsVisible){
                linearLayout.visibility = View.VISIBLE
            } else {
                linearLayout.visibility = View.INVISIBLE
            }
        }


        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}