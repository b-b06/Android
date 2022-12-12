package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        var logoutTextView=findViewById<TextView>(R.id.textView6)
        logoutTextView.setOnClickListener{
            var intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("mytag","3rd activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","3rd activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","3rd activity paused")

    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","3rd activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","3rd activity destroyed")
    }

}