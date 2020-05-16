package com.manurung.testmagangandroiddot.remote

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("Gallery_Malang_Batu.json")
    fun getGalleryList(): Call<List<GalleryList>>
}