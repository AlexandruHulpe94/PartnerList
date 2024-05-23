package com.example.partnerlist.presentation.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.partnerlist.data.model.Partner
import com.example.partnerlist.databinding.ActivityPartnerDetailBinding

class PartnerDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: PartnerDetailViewModel
    private lateinit var binding: ActivityPartnerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartnerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PartnerDetailViewModel::class.java]

        val partner: Partner? = intent.getParcelableExtra("partner")
        viewModel.selectedPartner.value = partner

        binding.tvName.text = partner?.name
        binding.tvDescription.text = partner?.description
        Glide.with(this).load(partner?.image_url).into(binding.ivImage)
    }
}


