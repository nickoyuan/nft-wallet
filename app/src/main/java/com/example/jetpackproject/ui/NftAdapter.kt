package com.example.jetpackproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.jetpackproject.R

class NftAdapter : ListAdapter<String, NftViewHolder>(ASYNC_DIFF) {

    private var ipfsDataList : MutableList<String> = mutableListOf()

    companion object {
        private val ASYNC_DIFF = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
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

    fun addNewItem(item : String) {
        ipfsDataList.add(item)
        submitList(ipfsDataList)
        notifyDataSetChanged()
    }

    fun clearItemList() {
        submitList(null)
        ipfsDataList.clear()
    }
}

