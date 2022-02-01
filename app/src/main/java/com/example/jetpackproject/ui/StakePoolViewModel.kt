package com.example.jetpackproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackproject.R
import com.example.jetpackproject.model.IpfsData
import com.example.jetpackproject.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StakePoolViewModel @Inject constructor(private val nftRepository: NftRepository) : ViewModel() {

    val screenState: LiveData<ViewState<MutableList<IpfsData>>> get() = _screenState
    private val _screenState = MutableLiveData<ViewState<MutableList<IpfsData>>>(ViewState.idle())

    val walletId = WalletId()
    val walletIdErrorLiveData = MutableLiveData<Int>()

    fun fetchWallets() {
        if (walletId.id.isEmpty()) {
            walletIdErrorLiveData.postValue(R.string.wallet_id_error)
        } else {
            viewModelScope.launch {
                nftRepository.getNftDataFromWallet(walletId.id).collect {
                    if(it.data?.onChainMetaData != null) {
                       // TODO how do i update the view ?
                    }
                }
            }
        }

    }
}