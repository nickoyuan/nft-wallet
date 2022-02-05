package com.example.jetpackproject.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackproject.R
import com.example.jetpackproject.databinding.ActivityMainBinding
import com.example.jetpackproject.model.ViewState.State.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val stakePoolViewModel: StakePoolViewModel by viewModels()
    private lateinit var nftAdapter: NftAdapter
    private lateinit var ipfsDataList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = stakePoolViewModel
        setupNftAdapter(binding.nftRecyclerView)
        ipfsDataList = mutableListOf()
        handleResponse()
    }

    private fun setupNftAdapter(nftRecyclerView: RecyclerView) {
        nftAdapter = NftAdapter()
        with(nftRecyclerView) {
            adapter = nftAdapter
            layoutManager = GridLayoutManager(context, 2)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun handleResponse() {
        stakePoolViewModel.screenState.observe(this, Observer {
            when (it.state) {
                SUCCESS -> {
                    binding.progressCircular.visibility = GONE
                    binding.errorMsg.visibility = GONE
                    nftAdapter.addNewItem(it.data!!)
                }
                LOADING -> {
                    binding.progressCircular.visibility = VISIBLE
                    binding.errorMsg.visibility = GONE
                    nftAdapter.clearItemList()
                }
                ERROR -> {
                    binding.errorMsg.visibility = VISIBLE
                    binding.progressCircular.visibility = GONE
                }
                else -> {}
            }
        })
    }
}