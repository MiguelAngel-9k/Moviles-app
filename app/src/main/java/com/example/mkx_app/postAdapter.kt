package com.example.mkx_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class postAdapter(val posts: List<Post>):
    RecyclerView.Adapter<postAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val postImage:ImageView = view.findViewById<ImageView>(R.id.postImage)
        private val title: TextView = view.findViewById<TextView>(R.id.txtPostTitle)
        private val user:TextView = view.findViewById<TextView>(R.id.txtUserName)
        private val userImage:ImageView = view.findViewById<ImageView>(R.id.userImage)

        fun loadPost(post: Post){
           Glide.with(postImage.context).load(post.image).into(postImage)
            title.setText(post.title)
            user.setText(post.user)
            Glide.with(userImage.context).load(post.userImage).into(userImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.loadPost(post)
    }

    override fun getItemCount(): Int = posts.size
}