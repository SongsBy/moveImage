package com.example.a2023158066_31

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class mover : AppCompatActivity() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var imageView: ImageView
    private lateinit var top: Button
    private lateinit var bottom: Button
    private lateinit var left: Button
    private lateinit var right: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mover)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        frameLayout = findViewById(R.id.frame)
        imageView = findViewById(R.id.imageView)
        top = findViewById(R.id.top)
        bottom = findViewById(R.id.bottom)
        left = findViewById(R.id.left)
        right = findViewById(R.id.right)



        top.setOnClickListener {
            top.setBackgroundColor(Color.RED)
            mov(0f, -100f)
        }

        bottom.setOnClickListener {
            bottom.setBackgroundColor(Color.RED)
            mov(0f, 100f)
        }

        left.setOnClickListener {
            left.setBackgroundColor(Color.RED)
            mov(-100f, 0f)
        }

        right.setOnClickListener {
            right.setBackgroundColor(Color.RED)
            mov(100f, 0f)
        }


        title = "imageMover"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onSupportNavigateUp() = onBackPressedDispatcher.onBackPressed().run { true }



    private fun mov(dx: Float, dy: Float) {

        val newX = imageView.x + dx
        val newY = imageView.y + dy

        if (newX >= 0 && newX + imageView.width <= frameLayout.width)
            imageView.x = newX
        if (newY >= 0 && newY + imageView.height <= frameLayout.height)
            imageView.y = newY
    }
}

