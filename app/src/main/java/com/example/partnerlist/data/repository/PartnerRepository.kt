package com.example.partnerlist.data.repository

import com.example.partnerlist.data.api.RetrofitInstance
import com.example.partnerlist.data.model.Partner
import com.example.partnerlist.utils.Resource

class PartnersRepository {
    suspend fun getPartners(): Resource<List<Partner>> {
        val response = RetrofitInstance.api.getPartners()
        return if (response.isSuccessful) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(response.message())
        }
    }
}
