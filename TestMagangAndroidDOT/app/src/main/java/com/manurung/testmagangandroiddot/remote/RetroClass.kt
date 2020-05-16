package com.manurung.testmagangandroiddot.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroClass {
    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://info-malang-batu.firebaseapp.com/"

        private fun getRetroInstance(): Retrofit? {
            val gson = GsonBuilder().setLenient().create()

            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }

            return retrofit
        }

        fun getAPIService(): APIService {
            return getRetroInstance()!!.create(APIService::class.java)
        }
    }
}