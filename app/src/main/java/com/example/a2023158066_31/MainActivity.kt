package com.example.a2023158066_31

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        title = "중간고사"

        var get1 = findViewById<TextView>(R.id.tXt1)
        var get2 = findViewById<TextView>(R.id.txt2)
        var get3 = findViewById<TextView>(R.id.txt3)


        var massage1 = intent.getStringExtra("txt1")
        var massage2 = intent.getStringExtra("txt2")
        var massage3 = intent.getStringExtra("txt3")

        get1.text = massage1 ?: "소프트웨어공학과"
        get2.text = massage2 ?: "2023158066"
        get3.text = massage3 ?: "송정훈"



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.more1 ->  {
                intent = Intent(this, mover ::class.java)
                startActivity(intent)

                true
        }
            R.id.more2 -> {
                intent = Intent(this , anymation ::class.java)
                startActivity(intent)
                true
            }

            R.id.manage ->{
                intent = Intent(this, MainActivity2 ::class.java)
                startActivity(intent)
                true
            }
        else -> onOptionsItemSelected(item)
        }
    }

}