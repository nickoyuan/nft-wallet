package com.example.jetpackproject.model

import com.google.gson.annotations.SerializedName

data class IpfsData(
    @SerializedName("onchain_metadata")
    var onChainMetaData: OnChainMetaData?
)

data class OnChainMetaData(
    @SerializedName("image")
    var image : String?
)
