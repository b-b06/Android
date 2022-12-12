package com.example.serviceproj

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver :BroadcastReceiver() {
    override fun onReceive(ctx: Context?, intent: Intent?) {
        Toast.makeText(ctx,"Music service initiated",Toast.LENGTH_LONG).show()
        var cmd=intent?.getStringExtra("key")
        var myIntent=Intent(ctx,MyService::class.java)
        if(cmd=="Play Music"){
            ctx?.startService(myIntent)
        }
    }

}