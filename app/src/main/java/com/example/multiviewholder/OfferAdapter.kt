package com.example.multiviewholder

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.databinding.BannerBinding
import com.example.multiviewholder.databinding.OfferItemBinding

class OfferAdapter(val list: List<Int>) : RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {
    inner class OfferViewHolder(var binding: OfferItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Int) {
            binding.imageOffer.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding: OfferItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.offer_item,
            parent,
            false
        )
        return OfferViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(list[position])
    }

}