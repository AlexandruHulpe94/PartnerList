package com.example.partnerlist.domain

import com.example.partnerlist.data.repository.PartnersRepository
import com.example.partnerlist.presentation.list.PartnerGroup
import com.example.partnerlist.utils.Resource

class GetPartnersUseCase(private val partnersRepository: PartnersRepository) {
    suspend operator fun invoke(): Resource<List<PartnerGroup>> {
        val result = partnersRepository.getPartners()
        return if (result is Resource.Success) {
            val groupedPartners = result.data!!.groupBy { it.rating }.map {
                PartnerGroup(it.key, it.value)
            }.sortedBy { it.rating }
            Resource.Success(groupedPartners)
        } else {
            Resource.Error(result.message!!)
        }
    }
}











