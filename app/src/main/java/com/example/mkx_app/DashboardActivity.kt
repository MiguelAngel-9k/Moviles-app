package com.example.mkx_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    private var recycler:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    init {
        recycler = findViewById<RecyclerView>(R.id.postContainer)
    }
}