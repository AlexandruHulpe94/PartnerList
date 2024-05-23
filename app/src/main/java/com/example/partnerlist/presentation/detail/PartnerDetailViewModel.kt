package com.example.partnerlist.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.partnerlist.data.model.Partner

class PartnerDetailViewModel : ViewModel() {
    val selectedPartner = MutableLiveData<Partner>()
}
