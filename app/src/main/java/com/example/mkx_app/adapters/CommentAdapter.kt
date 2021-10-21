package com.example.mkx_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.models.Comment

class CommentAdapter(val comments:List<Comment>):RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        private val commentUser = view.findViewById<TextView>(R.id.txtCommentUser)

        fun loadComment(comment:Comment){
            this.commentUser.setText(comment.title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = this.comments[position]
        holder.loadComment(comment)
    }

    override fun getItemCount(): Int = comments.size
}