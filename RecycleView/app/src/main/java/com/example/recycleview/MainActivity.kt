package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myUserList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myRecyclerView = findViewById<RecyclerView>(R.id.myrv)
        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        myUserList = ArrayList<User>()
        var myAdapter = MyAdapter(myUserList)
        myRecyclerView.adapter = myAdapter

        addUserData()

    }

    private fun addUserData() {

        var u1 = User("Ansari", "123")
        myUserList.add(u1)

        var u2 = User("Ravi", "33232")
        myUserList.add(u2)

        var u3 = User("Suresh", "324232")
        myUserList.add(u3)

        var u4 = User("Ramesh", "14423")
        myUserList.add(u4)

        var u5 = User("Harish", "123")
        myUserList.add(u5)

        var u6 = User("ravish", "123")
        myUserList.add(u5)

        var u7 = User("Abdul", "123")
        myUserList.add(u5)
    }
}