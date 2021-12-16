package com.example.jetpackproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nftCardText: TextView = itemView.findViewById(R.id.nft_card_text)

    fun bind(model: NftData) {
        nftCardText.text = model.nftTitle
    }
}
