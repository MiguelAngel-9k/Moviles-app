package com.example.mkx_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val recycler:RecyclerView = findViewById<RecyclerView>(R.id.postRecycler)

        recycler.adapter = postAdapter(listOf(
            Post("https://loremflickr.com/320/240","mike", "Primer post de la app", "https://loremflickr.com/320/240/dog", 0),
            Post("https://loremflickr.com/320/240/dog","Lucius", "Segundo post de la app", "https://loremflickr.com/320/240/dog", 0),
            Post("https://loremflickr.com/320/240/dog","Tony", "Tercero post de la app", "https://loremflickr.com/320/240/dog", 0),
            Post("https://loremflickr.com/320/240/dog","Mark", "Cuarto post de la app", "https://loremflickr.com/320/240/dog", 0),
            Post("https://loremflickr.com/320/240/dog","Antonio", "Quinto post de la app", "https://loremflickr.com/320/240/dog", 0)
        ))
    }
}