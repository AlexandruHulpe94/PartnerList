package com.example.partnerlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partnerlist.data.repository.PartnersRepository
import com.example.partnerlist.domain.GetPartnersUseCase
import com.example.partnerlist.presentation.list.PartnersListViewModel

class ViewModelFactory(private val getPartnersUseCase: GetPartnersUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PartnersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PartnersListViewModel(getPartnersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


