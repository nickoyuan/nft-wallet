package com.example.jetpackproject.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpackproject.R
import com.example.jetpackproject.util.Util

class NftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nftCardImg: ImageView = itemView.findViewById(R.id.nft_image)

    fun bind(ipfsUrl: String) {
        Glide.with(nftCardImg.context)
            .load(ipfsUrl)
            .placeholder(Util.circularDrawable(nftCardImg.context))
            .fitCenter()
            .into(nftCardImg)
    }
}
