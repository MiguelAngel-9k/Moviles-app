package com.example.mkx_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PostImagesAdapter(val posts:List<Post>):RecyclerView.Adapter<PostImagesAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val postImage: ImageView = view.findViewById<ImageView>(R.id.coverImage)

        fun loadImage(post:Post){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.images_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.loadImage(post)
    }

    override fun getItemCount(): Int = posts.size
}