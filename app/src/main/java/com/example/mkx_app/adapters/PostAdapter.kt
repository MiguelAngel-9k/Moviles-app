package com.example.mkx_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.models.Post
import java.util.zip.Inflater

class PostAdapter(val posts:List<Post>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val postCover = view.findViewById<ImageView>(R.id.imgPostCover)
        private val postTitle = view.findViewById<TextView>(R.id.txtPostTitle)
        private val postBy = view.findViewById<TextView>(R.id.txtPostBy)
        private val postUser = view.findViewById<ImageView>(R.id.imgPostUser)

        //Hacer funcion para el rate

        fun loadPost(post:Post){
            postTitle.setText(post.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_post_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val post = this.posts[position]
        holder.loadPost(post)
    }

    override fun getItemCount(): Int = this.posts.size

}