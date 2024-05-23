package com.example.partnerlist.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Partner(
    val id: String,
    val name: String,
    val description: String,
    val rating: Int,
    val image_url: String
) : Parcelable

