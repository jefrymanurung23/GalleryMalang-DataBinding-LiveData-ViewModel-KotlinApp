package com.manurung.testmagangandroiddot.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manurung.testmagangandroiddot.R
import com.manurung.testmagangandroiddot.model.Gallery
import com.manurung.testmagangandroiddot.remote.UserRepository
import com.squareup.picasso.Picasso

class GalleryViewModel : ViewModel() {
    lateinit var caption: String
    lateinit var thumbnail: String
    lateinit var image: String

    private var arrayListMutableLiveData = MutableLiveData<ArrayList<GalleryViewModel>>()

    init {
        val userRepository = UserRepository()
        arrayListMutableLiveData = userRepository.getAllData()
    }


    private var galleryViewModels = ArrayList<GalleryViewModel>()

    fun getGalleryThumbnail(): String {
        return thumbnail
    }

    fun getGalleryImage(): String {
        return image
    }

    fun getAllArrayListMutableLiveData(): MutableLiveData<ArrayList<GalleryViewModel>> {

        return arrayListMutableLiveData
    }

}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    Picasso.get().load(imageUrl).placeholder(R.drawable.icon_galery).into(imageView)
}

@BindingAdapter("thumbnailUrl")
fun loadThumbnail(imageView: ImageView, thumbnailUrl: String?) {
    Picasso.get().load(thumbnailUrl).placeholder(R.drawable.icon_galery).into(imageView)
}

fun GalleryViewModel(gallery: Gallery): GalleryViewModel = GalleryViewModel().apply {
    caption = gallery.caption
    thumbnail = gallery.thumbnail
    image = gallery.image
}