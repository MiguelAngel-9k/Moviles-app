package com.example.mkx_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(val comments:List<Comment>):
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val commentTitle:TextView = view.findViewById<TextView>(R.id.txtCommentTitle)
        private val commentContent:TextView = view.findViewById<TextView>(R.id.txtCommentContent)

        fun loadComment(comment:Comment){
            commentTitle.setText(comment.title)
            commentContent.setText(comment.content)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]
        holder.loadComment(comment)
    }

    override fun getItemCount(): Int = comments.size
}