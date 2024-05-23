package com.example.partnerlist.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://662f244a43b6a7dce30e7f2a.mockapi.io/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PartnersApi by lazy {
        retrofit.create(PartnersApi::class.java)
    }
}
