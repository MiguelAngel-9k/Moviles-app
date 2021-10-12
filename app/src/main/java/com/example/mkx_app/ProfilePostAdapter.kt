package com.example.mkx_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfilePostAdapter(val posts: List<Post>):
RecyclerView.Adapter<ProfilePostAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val postTitle: TextView = view.findViewById<TextView>(R.id.txtProfilePostTitle)

        fun loadProfilePost(post:Post){
            this.postTitle.setText(post.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.loadProfilePost(post)
    }

    override fun getItemCount(): Int = posts.size
}