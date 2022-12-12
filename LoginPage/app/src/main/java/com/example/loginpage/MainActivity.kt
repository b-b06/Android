package com.example.loginpage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var usernameEditText=findViewById<EditText>(R.id.editTextTextPersonName)
        var passwordEditText=findViewById<EditText>(R.id.editTextTextPassword)
        //var usernameTextView=findViewById<TextView>(R.id.textView2)
        var signupTextView=findViewById<TextView>(R.id.textView3)
        signupTextView.setOnClickListener{
            var intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        var submitButton=findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {
            var username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                if (username == "bob" && password == "123") {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()
                    //usernameTextView.setText(username)
                    var myIntent=Intent(this,Activity2::class.java)
                    myIntent.putExtra("username",username)
                    myIntent.putExtra("password",password)
                    startActivity(myIntent)
                } else {
                    Toast.makeText(this, "Please check the credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","Main activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","Main activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","Main activity paused")

    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","Main activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","Main activity destroyed")
    }
}