package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myIntentFilter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        var myReceiver = MyReceiver()
        Log.i("mytag","Main Received")
        registerReceiver(myReceiver, myIntentFilter)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS) ==
            PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECEIVE_SMS), 1234)
        }
        //encrypting data without shared preferences---------------------------------

        var usernameEditText=findViewById<EditText>(R.id.editTextTextPersonName)
        var passwordEditText=findViewById<EditText>(R.id.editTextTextPersonName2)
        var textV=findViewById<TextView>(R.id.textView)
        lateinit var sp : SharedPreferences


        sp = getSharedPreferences("myfile", MODE_PRIVATE)

        usernameEditText.setText(sp.getString("key1",""))
        passwordEditText.setText(sp.getString("key2",""))

        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        val securePreferences = EncryptedSharedPreferences.create(
            "myfile",
            mainKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )



        textV.setOnClickListener {
            var username1 = usernameEditText.text.toString()
            var password1=passwordEditText.text.toString()
            var editor = securePreferences.edit()
            editor.putString("key1", username1)
            editor.putString("key2",password1)
            editor.commit()
            Toast.makeText(this,"Encryption successful!",Toast.LENGTH_LONG).show()
        }
    }
}
//Broasdcasting music request to service of music application
//        var textV=findViewById<TextView>(R.id.textView)
//        //var myIntent=IntentFilter("android.intent.action.AIRPLANE_MODE")
//        textV.setOnClickListener{
//            var myIntent= Intent("Sender_Intent")
//            myIntent.putExtra("key","Play Music")
//            myIntent.action="play_music"
//            sendBroadcast(myIntent)
//        }
        //var myReceiver=MyReceiver()
        //registerReceiver(myReceiver,myIntent)
