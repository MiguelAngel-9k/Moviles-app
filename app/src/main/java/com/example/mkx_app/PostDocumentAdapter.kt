package com.example.mkx_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostDocumentAdapter(val posts:List<Post>): RecyclerView.Adapter<PostDocumentAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val document = view.findViewById<TextView>(R.id.txtDocument)

        fun loadDocuments(post: Post){
            document.setText(post.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.document_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = posts[position]
        holder.loadDocuments(comment)
    }

    override fun getItemCount(): Int = posts.size
}