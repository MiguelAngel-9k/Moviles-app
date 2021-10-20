package com.example.mkx_app.acyivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.adapters.PostAdapter
import com.example.mkx_app.models.Post

class DashboardActivity : AppCompatActivity() {

    private var postRecycler:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        this.postRecycler = findViewById<RecyclerView>(R.id.RvRecent)

        postRecycler?.adapter = PostAdapter(
            listOf(
            Post("Title1"),
            Post("Title2"),
            Post("Title3"),
            Post("Title4"),
            Post("Title5"),
            Post("Title6")
        )
        )

    }
}