package com.manurung.testmagangandroiddot.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.manurung.testmagangandroiddot.R
import com.manurung.testmagangandroiddot.databinding.GalleryBinding
import com.manurung.testmagangandroiddot.viewmodel.GalleryViewModel

class CustomAdapter(private var context: Context, private var arrayList: ArrayList<GalleryViewModel>) : BaseAdapter() {
    private lateinit var galleryBinding: GalleryBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if ( view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.innerlayout, null)
            galleryBinding = DataBindingUtil.bind(view)!!
            view.tag = galleryBinding
        } else {
            galleryBinding = convertView!!.tag as GalleryBinding
        }

        galleryBinding.galerymodel = arrayList[position]

        return galleryBinding.root
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}