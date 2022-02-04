package com.example.jetpackproject.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NftRepository @Inject constructor(private val apiProvider: ApiProvider) {
    fun getNftDataFromWallet(id: String) = flow {
            apiProvider.getNftUnits(id)
                .map {
                    val ipfsUrl = apiProvider.getIpfsUrl(it.nftUnit)
                    emit(ipfsUrl)
                }
        }.flowOn(Dispatchers.IO)

}