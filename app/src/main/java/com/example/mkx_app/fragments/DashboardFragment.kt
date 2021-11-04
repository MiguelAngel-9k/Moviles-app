package com.example.mkx_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mkx_app.R
import com.example.mkx_app.adapters.PostAdapter
import com.example.mkx_app.models.Post

class DashboardFragment : Fragment() {

    private lateinit var postRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)

        postRecycler = view.findViewById<RecyclerView>(R.id.RvRecent)

        postRecycler.adapter = PostAdapter(
            listOf(
                Post("Title1"),
                Post("Title2"),
                Post("Title3"),
                Post("Title4"),
                Post("Title5"),
                Post("Title6")
            ),
            R.layout.fragment_post_view
        )

        return view
    }
}