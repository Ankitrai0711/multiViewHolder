package com.example.multiviewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.multiviewholder.databinding.StoresItemBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class StoreAdapter(val data: ApiData, val context: Context) :
    RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    inner class StoreViewHolder(var binding: StoresItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ApiData.Store) {
            image.businessHours?.forEach {
                if (it?.day!!.equals(getCurrentDay(), ignoreCase = true)) {
                    if (it.isAvalilable247 == true) {
                        binding.timing.setTextColor(context.getColor(R.color.green))
                        binding.timing.text = context.getString(R.string.open24)
                    } else if (it.storeTimings?.isEmpty() == true) {
                        binding.timing.text = context.getString(R.string.closed)
                        binding.timing.setTextColor(context.getColor(R.color.red))
                    } else it.storeTimings!!.forEach {
                        binding.timing.setTextColor(context.getColor(R.color.green))
                        binding.timing.text = context.getString(
                            R.string.timing,
                            concertTo12HoursFormate(it?.openTime.toString()),
                            concertTo12HoursFormate(it?.closeTime.toString())
                        )
                    }
                }
            }

            binding.address.text = image.storeAddress.toString()
            Glide.with(context).load(image.storeImagePath).into(binding.storeImage)


        }
    }

    private fun concertTo12HoursFormate(timing: String): String {
        val inputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val data = inputFormat.parse(timing)
        return outputFormat.format(data!!).toString()
    }

    private fun getCurrentDay(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreAdapter.StoreViewHolder {
        val binding: StoresItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.stores_item,
            parent,
            false
        )
        return StoreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.stores!!.size
    }

    override fun onBindViewHolder(holder: StoreAdapter.StoreViewHolder, position: Int) {
        data.stores?.get(position)?.let { holder.bind(it) }
    }

}