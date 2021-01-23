package com.haurbano.stt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavigate = findViewById<Button>(R.id.navigateBtn)
        btnNavigate.setOnClickListener { SecondActivity.start(this) }
    }
}