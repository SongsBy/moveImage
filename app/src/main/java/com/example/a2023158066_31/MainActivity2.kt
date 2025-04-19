package com.example.a2023158066_31

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        title = "개인 정보 수정"

        var input1 = findViewById<EditText>(R.id.edt1)
        var input2 = findViewById<EditText>(R.id.edt2)
        var input3 = findViewById<EditText>(R.id.edt3)
        var inputbtn = findViewById<Button>(R.id.button)

        inputbtn.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            inputbtn.setBackgroundColor(Color.RED)

            var txt1 =  input1.text.toString()
            var txt2 =  input2.text.toString()
            var txt3 =  input3.text.toString()

            intent.putExtra("txt1", txt1)
            intent.putExtra("txt2", txt2)
            intent.putExtra("txt3", txt3)

            startActivity(intent)
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}