package com.example.jetpackproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StakePoolViewModel : ViewModel() {

    fun fetchWallets() {

    }
}

class StakePoolViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StakePoolViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StakePoolViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}