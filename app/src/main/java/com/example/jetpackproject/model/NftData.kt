package com.example.jetpackproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NftData(
    @SerializedName("unit")
    var nftUnit: String = "") : Serializable {
    companion object {
        private const val serialVersionUID = -60569697463775285L
    }
}

