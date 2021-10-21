package com.example.mkx_app.acyivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.adapters.PostAdapter
import com.example.mkx_app.models.Post

class PostContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_content)

        val post = listOf(
            Post("Title1"),
            Post("Title2"),
            Post("Title3"),
            Post("Title4"),
            Post("Title5"),
            Post("Title6")
        )

        val postContentRecyclerView = findViewById<RecyclerView>(R.id.RvContentImg)
        val documentRecyclerView = findViewById<RecyclerView>(R.id.RvContentDocument)

        postContentRecyclerView.adapter = PostAdapter(post, R.layout.fragment_cover_post)
        documentRecyclerView.adapter = PostAdapter(post, R.layout.fragment_document)
    }
}