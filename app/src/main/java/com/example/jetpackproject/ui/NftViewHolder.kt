package com.example.jetpackproject.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackproject.R
import com.example.jetpackproject.model.NftData

class NftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nftCardText: TextView = itemView.findViewById(R.id.nft_card_text)

    fun bind(model: NftData) {
        nftCardText.text = model.nftUnit
    }
}
