package com.manurung.testmagangandroiddot.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Gallery {

    @SerializedName("caption")
    @Expose
    lateinit var caption: String

    @SerializedName("thumbnail")
    @Expose
    lateinit var thumbnail: String

    @SerializedName("image")
    @Expose
    lateinit var image: String
}

fun Gallery(caption: String, image: String, thumbnail: String): Gallery = Gallery().apply {
    this.caption = caption
    this.thumbnail = thumbnail
    this.image = image
}