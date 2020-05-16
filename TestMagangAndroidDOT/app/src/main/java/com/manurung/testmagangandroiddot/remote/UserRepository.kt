package com.manurung.testmagangandroiddot.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.manurung.testmagangandroiddot.model.Gallery
import com.manurung.testmagangandroiddot.viewmodel.GalleryViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    var data = MutableLiveData<ArrayList<GalleryViewModel>>()

    fun getAllData(): MutableLiveData<ArrayList<GalleryViewModel>>{
        val apiService = RetroClass.getAPIService()
        val galleryListCall = apiService.getGalleryList()

        galleryListCall.enqueue(object : Callback<List<GalleryList>> {
            override fun onResponse(
                call: Call<List<GalleryList>>,
                response: Response<List<GalleryList>>
            ) {

//                Log.d("Response", ""+response.body()!!.size)

                val galleryViewModels: ArrayList<GalleryViewModel> = ArrayList()
                var gallery: Gallery
//                Log.d("Gallery5", ""+galleryViewModels.size)

                for (user in response.body()!!) {
                    val items = user.getAll()
//                    Log.d("Gallery", ""+items[0])
                    gallery = Gallery(items[0], items[1], items[2])
//                    Log.d("Gallery2", ""+gallery.caption)
                    val galleryViewModel = GalleryViewModel(gallery)
//                    Log.d("Gallery3", ""+galleryViewModel.caption)
                    galleryViewModels.add(galleryViewModel)
//                    Log.d("Gallery4", ""+galleryViewModels.size)
                }

//                Log.d("BERHASIL BOS", ""+ galleryViewModels!![0].caption)
                data.value = galleryViewModels
            }

            override fun onFailure(call: Call<List<GalleryList>>, t: Throwable) {
                Log.d("Fail Response", ""+t)
            }
        })

        return data
    }

}