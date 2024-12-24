package com.example.multiviewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.databinding.BannerRecyclerViewBinding
import com.example.multiviewholder.databinding.OfferRecyclerViewBinding
import com.example.multiviewholder.databinding.StoreRecyclerviewBinding
import java.lang.IllegalArgumentException

class MainAdapter(val context: Context, val data: Data) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val Offer = 1
        const val Banner = 0
        const val Store = 2
    }

    inner class BannerViewHolder(val binding: BannerRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: List<Int>) {
            binding.bannerRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.bannerRecyclerView.adapter = BannerAdapter(banner)
        }

    }

    inner class StoreViewHolder(val binding: StoreRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(store: ApiData) {
            binding.storeRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.storeRecyclerView.adapter = StoreAdapter(store, context)
        }

    }

    inner class OfferViewHolder(val binding: OfferRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: List<Int>) {
            binding.offerRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.offerRecyclerView.adapter = OfferAdapter(offer)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            Offer -> {
                1
            }

            Banner -> {
                0
            }

            Store -> {
                2
            }

            else -> {
                4
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {

            Offer -> {
                val binding: OfferRecyclerViewBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.offer_recycler_view,
                    parent,
                    false
                )
                return OfferViewHolder(binding)
            }

            Banner -> {
                val binding: BannerRecyclerViewBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.banner_recycler_view,
                    parent,
                    false
                )
                return BannerViewHolder(binding)
            }

            Store -> {
                val binding: StoreRecyclerviewBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.store_recyclerview,
                    parent,
                    false
                )
                return StoreViewHolder(binding)
            }

            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OfferViewHolder -> (holder as OfferViewHolder).bind(data.offer)
            is StoreViewHolder -> (holder as StoreViewHolder).bind(data.store)
            is BannerViewHolder -> (holder as BannerViewHolder).bind(data.banner)

            else -> {}
        }
    }
}