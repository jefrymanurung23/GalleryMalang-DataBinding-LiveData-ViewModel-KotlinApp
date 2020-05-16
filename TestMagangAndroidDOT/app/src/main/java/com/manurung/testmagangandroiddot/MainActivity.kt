package com.manurung.testmagangandroiddot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manurung.testmagangandroiddot.adapter.CustomAdapter
import com.manurung.testmagangandroiddot.viewmodel.GalleryViewModel

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        gridView = findViewById(R.id.gridView)

        galleryViewModel.getAllArrayListMutableLiveData().observe(this, Observer<ArrayList<GalleryViewModel>>() {
            val customAdapter = CustomAdapter(this@MainActivity, it)

            Log.d("Gallery View Model Size", ""+it[0].image)
            Log.d("Gallery View Model Size", ""+it[0].thumbnail)

            gridView.adapter = customAdapter

            gridView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    intent.putExtra("caption", it[position].caption)
                    intent.putExtra("image", it[position].thumbnail)

                    startActivity(intent)
                }

//            showToast(""+it.size)
        })
    }

    fun showToast(msg: String) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show()
    }


}
