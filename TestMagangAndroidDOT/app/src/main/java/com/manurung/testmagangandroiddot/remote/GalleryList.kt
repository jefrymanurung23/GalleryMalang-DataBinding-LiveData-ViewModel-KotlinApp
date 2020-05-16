package com.manurung.testmagangandroiddot.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GalleryList {
    @SerializedName("caption")
    @Expose
    lateinit var captions: String

    @SerializedName("thumbnail")
    @Expose
    lateinit var thumbnails: String

    @SerializedName("image")
    @Expose
    lateinit var images: String

    fun getCaption(): String {
        return captions
    }

    fun getThumbnail(): String {
        return thumbnails
    }

    fun getImage(): String {
        return images
    }

    fun getAll(): List<String> {
        return listOf<String>(captions, thumbnails, images)
    }

}
