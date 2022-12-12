package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var usernameEditText=findViewById<EditText>(R.id.editTextTextPersonName2)
        var passwordEditText=findViewById<EditText>(R.id.editTextTextPersonName3)
        var emailEditText=findViewById<EditText>(R.id.editTextTextPersonName4)
        var studentCheckBox=findViewById<CheckBox>(R.id.checkBox)
        var internCheckBox=findViewById<CheckBox>(R.id.checkBox2)
        var registerButton=findViewById<Button>(R.id.button4)
        registerButton.setOnClickListener{
            var myIntent=Intent(Intent.ACTION_DIAL)
            startActivity(myIntent)
        }
    }
}