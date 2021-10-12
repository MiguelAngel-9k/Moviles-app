package com.example.mkx_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        val recycler:RecyclerView = findViewById<RecyclerView>(R.id.recyclerComment)
        recycler.adapter = CommentAdapter(listOf(
            Comment("Primer Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Primer Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Segundo iComentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Tercero Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Cuarto Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Quinto Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Sexto Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop "),
            Comment("Septimo Comentario", "Cupcake ipsum dolor sit amet. Marshmallow chocolate cake fruitcake donut biscuit lollipop ")
        ))
    }
}