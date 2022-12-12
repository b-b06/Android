package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        var resUsername=findViewById<TextView>(R.id.textView2)
        resUsername.text=intent.extras?.getString("username")
        var resPassword=findViewById<TextView>(R.id.textView7)
        resPassword.text=intent.extras?.getString("password")
        var backButton=findViewById<Button>(R.id.button2)
        var nextButton=findViewById<Button>(R.id.button3)
        backButton.setOnClickListener{
            var myIntent= Intent(this,MainActivity::class.java)
            startActivity(myIntent)
        }
        nextButton.setOnClickListener{
            var myIntent2=Intent(this, Activity3::class.java)
            startActivity(myIntent2)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("mytag","2nd activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","2nd activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","2nd activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","2nd activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","2nd activity destroyed")
    }

}