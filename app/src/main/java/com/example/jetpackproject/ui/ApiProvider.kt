package com.example.jetpackproject.ui

import com.example.jetpackproject.model.IpfsData
import com.example.jetpackproject.model.NftData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProvider {
    @GET("accounts/{id}/addresses/assets")
    suspend fun getNftUnits(@Path("id") id: String) : List<NftData>

    @GET("assets/{unit}")
    suspend fun getIpfsUrl(@Path ("unit") unit : String) : IpfsData?
}
