package com.example.mkx_app.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.models.Post
import java.util.zip.Inflater

class PostAdapter(val posts:List<Post>, val layoutId: Int):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){

        /*private val postCover = view.findViewById<ImageView>(R.id.imgPostCover)
        private val postTitle = view.findViewById<TextView>(R.id.txtPostTitle)
        private val postBy = view.findViewById<TextView>(R.id.txtPostBy)
        private val postUser = view.findViewById<ImageView>(R.id.imgPostUser)*/

        //Hacer funcion para el rate

        fun loadPost(post:Post){
            when(layoutId){
                R.layout.fragment_post_view->{
                    val postTitle = view.findViewById<TextView>(R.id.txtPostTitle)
                    postTitle.setText(post.title)
                }
                R.layout.fragment_cover_post->{
                    val coverTitle = view.findViewById<TextView>(R.id.txtPostCovertitle)
                    coverTitle.setText(post.title)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(this.layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val post = this.posts[position]
        holder.loadPost(post)
    }

    override fun getItemCount(): Int = this.posts.size

}