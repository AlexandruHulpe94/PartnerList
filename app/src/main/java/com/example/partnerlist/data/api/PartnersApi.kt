package com.example.partnerlist.data.api

import com.example.partnerlist.data.model.Partner
import retrofit2.Response
import retrofit2.http.GET

interface PartnersApi {
    @GET("partners")
    suspend fun getPartners(): Response<List<Partner>>
}