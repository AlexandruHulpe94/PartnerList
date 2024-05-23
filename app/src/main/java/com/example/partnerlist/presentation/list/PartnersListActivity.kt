package com.example.partnerlist.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.partnerlist.data.repository.PartnersRepository
import com.example.partnerlist.databinding.ActivityPartnersListBinding
import com.example.partnerlist.domain.GetPartnersUseCase
import com.example.partnerlist.presentation.ViewModelFactory
import com.example.partnerlist.presentation.detail.PartnerDetailActivity
import com.example.partnerlist.utils.Resource

class PartnersListActivity : AppCompatActivity() {
    private lateinit var viewModel: PartnersListViewModel
    private lateinit var adapter: PartnersAdapter
    private lateinit var binding: ActivityPartnersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartnersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PartnersAdapter { partner ->
            val intent = Intent(this, PartnerDetailActivity::class.java)
            intent.putExtra("partner", partner)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(GetPartnersUseCase(PartnersRepository()))).get(
                PartnersListViewModel::class.java
            )

        viewModel.partners.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    resource.data?.let { adapter.setPartners(it) }
                }

                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



