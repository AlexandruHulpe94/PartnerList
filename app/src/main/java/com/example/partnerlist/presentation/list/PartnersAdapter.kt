package com.example.partnerlist.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.partnerlist.data.model.Partner
import com.example.partnerlist.databinding.ItemPartnerBinding
import com.example.partnerlist.utils.Resource

class PartnersAdapter(private val onPartnerClick: (Partner) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var partners = listOf<Any>()

    class RatingViewHolder(val binding: ItemPartnerBinding) : RecyclerView.ViewHolder(binding.root)
    class PartnerViewHolder(val binding: ItemPartnerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (partners[position] is Int) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val binding = ItemPartnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RatingViewHolder(binding)
        } else {
            val binding = ItemPartnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PartnerViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = partners[position]
        if (item is Int && holder is RatingViewHolder) {
            holder.binding.tvRating.text = "Rating: $item"
        } else if (item is Partner && holder is PartnerViewHolder) {
            holder.binding.tvName.text = item.name
            holder.binding.tvDescription.text = item.description
            holder.binding.root.setOnClickListener { onPartnerClick(item) }
        }
    }

    override fun getItemCount() = partners.size

    fun setPartners(partnerGroups: List<PartnerGroup>) {
        val items = partnerGroups.flatMap { group ->
            listOf(group.rating) + group.partners
        }
        this.partners = items
        notifyDataSetChanged()
    }
}


data class PartnerGroup(val rating: Int, val partners: List<Partner>)







