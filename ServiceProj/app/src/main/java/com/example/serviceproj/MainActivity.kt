package com.example.serviceproj

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startButton = findViewById<Button>(R.id.buttonStart)
        var stopButton = findViewById<Button>(R.id.buttonStop)

        startButton.setOnClickListener {
            var i = Intent(this, MyService::class.java)
            startService(i)
        }

        stopButton.setOnClickListener {
            var i = Intent(this, MyService::class.java)
            stopService(i)
        }
        var myIntent=IntentFilter("play_music")
        var myReceiver=MyReceiver()
        registerReceiver(myReceiver,myIntent)
    }
}