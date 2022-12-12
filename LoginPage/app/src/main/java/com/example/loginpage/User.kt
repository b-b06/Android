package com.example.loginpage

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var username:String,var password: String, var email:String):Parcelable{

}