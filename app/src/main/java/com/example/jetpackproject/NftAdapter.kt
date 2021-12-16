package com.example.jetpackproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class NftAdapter : ListAdapter<NftData, NftViewHolder>(ASYNC_DIFF) {

    companion object {
        private val ASYNC_DIFF = object : DiffUtil.ItemCallback<NftData>() {
            override fun areItemsTheSame(oldItem: NftData, newItem: NftData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NftData, newItem: NftData): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.nft_item_view, parent, false)
        return NftViewHolder(view)
    }

    override fun onBindViewHolder(holder: NftViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

