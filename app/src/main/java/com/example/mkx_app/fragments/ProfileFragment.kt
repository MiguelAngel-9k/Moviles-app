package com.example.mkx_app.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.adapters.PostAdapter
import com.example.mkx_app.models.Post
import com.example.mkx_app.models.User
import java.io.ByteArrayOutputStream

class ProfileFragment : Fragment() {

    lateinit var rvPorfilePost:RecyclerView
    lateinit var txtProfile: TextView
    lateinit var txtProfileEmail: TextView
    lateinit var imgUser: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        loadInforamtion(view)

        imgUser = view.findViewById(R.id.imgUserAvatar)
        val bitmap = getBitmapFromByteArray(User.avatar!!)
        imgUser.setImageBitmap(bitmap)

        rvPorfilePost = view.findViewById(R.id.RvUserPost)
        rvPorfilePost.adapter = PostAdapter(
            listOf(
                Post("Title1"),
                Post("Title2"),
                Post("Title3"),
                Post("Title4"),
                Post("Title5"),
                Post("Title6")
            ),
            R.layout.fragment_cover_post
        )
        return view
    }

    //Byte array to bitmap
    private fun getBitmapFromByteArray(data: ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }

    override fun onPause() {
        super.onPause()

        onDestroy()

    }

    private fun loadInforamtion(view:View){
        txtProfile = view.findViewById(R.id.txtProfile)
        txtProfile.setText(User.name + " " + User.lastName)
        
        txtProfileEmail = view.findViewById(R.id.txtProfileEmail)
        txtProfileEmail.setText(User.email)
    }
}