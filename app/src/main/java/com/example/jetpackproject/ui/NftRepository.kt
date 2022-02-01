package com.example.jetpackproject.ui

import com.example.jetpackproject.model.ViewState.Companion.error
import com.example.jetpackproject.model.ViewState.Companion.loading
import com.example.jetpackproject.model.ViewState.Companion.success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NftRepository @Inject constructor(private val apiProvider: ApiProvider) {
    fun getNftDataFromWallet(id: String) = flow {
            emit(loading())
            apiProvider.getNftUnits(id)
                .map {
                    emit(success(apiProvider.getIpfsUrl(it.nftUnit)))
                }
        }.catch {
            emit(error())
         }.flowOn(Dispatchers.IO)

}