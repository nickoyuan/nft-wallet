package com.example.jetpackproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackproject.R
import com.example.jetpackproject.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
ipfs://QmcUohJ3AR34hAPr1LAnA9zXXogYJQyMBfmJdC33aaKggF
 **/
@HiltViewModel
class StakePoolViewModel @Inject constructor(private val nftRepository: NftRepository) :
    ViewModel() {

    val screenState: LiveData<ViewState<String>> get() = _screenState
    private val _screenState = MutableLiveData<ViewState<String>>(ViewState.idle())

    val walletId = WalletId()
    val walletIdErrorLiveData = MutableLiveData<Int>()

    fun fetchWallets() {
        if (walletId.id.isEmpty()) {
            walletIdErrorLiveData.postValue(R.string.wallet_id_error)
        } else {
            viewModelScope.launch {
                _screenState.postValue(ViewState.loading())
                nftRepository.getNftDataFromWallet(walletId.id).catch {
                    _screenState.postValue(ViewState.error())
                }.collect {
                    if (it?.onChainMetaData?.image != null) {
                        val ipfsUrl =
                            it.onChainMetaData!!.image!!.replace(
                                "ipfs://",
                                "https://ipfs.io/ipfs/"
                            )
                        _screenState.postValue(ViewState.success((ipfsUrl)))
                    }
                }
            }
        }
    }
}
