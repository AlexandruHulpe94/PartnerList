package com.example.partnerlist.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.partnerlist.domain.GetPartnersUseCase
import com.example.partnerlist.utils.Resource
import kotlinx.coroutines.launch

class PartnersListViewModel(private val getPartnersUseCase: GetPartnersUseCase) : ViewModel() {
    private val _partners = MutableLiveData<Resource<List<PartnerGroup>>>()
    val partners: LiveData<Resource<List<PartnerGroup>>> = _partners

    init {
        fetchPartners()
    }

    private fun fetchPartners() = viewModelScope.launch {
        _partners.postValue(Resource.Loading())
        val result = getPartnersUseCase()
        _partners.postValue(result)
    }
}














