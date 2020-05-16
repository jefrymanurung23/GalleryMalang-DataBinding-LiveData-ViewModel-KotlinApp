package com.manurung.testmagangandroiddot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        val i = intent

        val caption = i.extras!!.getString("caption")
        val image = i.extras!!.getString("image")
        Picasso.get().load(image).placeholder(R.drawable.icon_galery).into(imageView)
        textView.text = caption
    }
}
