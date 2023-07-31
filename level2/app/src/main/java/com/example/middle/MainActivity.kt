package com.example.middle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.middle.model.User
import com.example.middle.model.users

class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate the list of users (You can use your own method to get the user list)
        userList = users

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(userList)
        findViewById<RecyclerView>(R.id.userRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}