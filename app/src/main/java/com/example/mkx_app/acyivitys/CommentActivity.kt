package com.example.mkx_app.acyivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.adapters.CommentAdapter
import com.example.mkx_app.models.Comment

class CommentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        val rvComment = findViewById<RecyclerView>(R.id.RvComment)
        rvComment.adapter = CommentAdapter(listOf(
            Comment("Comment 1"),
            Comment("Comment 2"),
            Comment("Comment 3"),
            Comment("Comment 4"),
            Comment("Comment 5"),
            Comment("Comment 6"),
            Comment("Comment 7"),
            Comment("Comment 8"),
            Comment("Comment 9"),
            Comment("Comment 10")
        ))

    }
}