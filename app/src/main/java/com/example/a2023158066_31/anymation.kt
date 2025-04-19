package com.example.a2023158066_31

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class anymation : AppCompatActivity() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var  imageView: ImageView
    private lateinit var start: Button
    private lateinit var pause: Button
    private lateinit var reset: Button

    private var isMover = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_anymation)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        frameLayout = findViewById(R.id.frame)
        imageView = findViewById(R.id.imageView2)
        start = findViewById(R.id.start)
        pause = findViewById(R.id.pause)
        reset = findViewById(R.id.reset)

        start.setOnClickListener {
            start.setBackgroundColor(Color.RED)
            startMov()
        }

        pause.setOnClickListener {
            pause.setBackgroundColor(Color.RED)
            pauseMov()
        }

        reset.setOnClickListener {
            reset.setBackgroundColor(Color.RED)
            resetMov()
        }

        title = "애니메이션"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onSupportNavigateUp() = onBackPressedDispatcher.onBackPressed().run { true }



    private fun startMov (){
        isMover = true
        start.isEnabled = false
        pause.isEnabled = true
        reset.isEnabled = true

        Thread{
            while (isMover){
                runOnUiThread {
                    imageView.apply {
                        imageView.x += 10f
                        imageView.y += 10f
                        if(x + imageView.width >= frameLayout.width || y + imageView.height >= frameLayout.height){
                            imageView.x = 0f
                            imageView.y = 0f
                        }
                    }
                }
                Thread.sleep(100)
            }
        }.start()
    }
    private fun pauseMov(){
        isMover = false
        start.isEnabled = true
        reset.isEnabled = true
        pause.isEnabled = false
        start.text = "재시작"
    }

    private fun resetMov(){
        isMover = false
        start.isEnabled = true
        pause.isEnabled = false
        reset.isEnabled = false

        start.text = "시작"

        imageView.x = 0f
        imageView.y = 0f
    }
}