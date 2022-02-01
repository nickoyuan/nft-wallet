package com.example.jetpackproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackproject.R
import com.example.jetpackproject.databinding.ActivityMainBinding
import com.example.jetpackproject.model.IpfsData
import com.example.jetpackproject.model.ViewState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val stakePoolViewModel: StakePoolViewModel by viewModels()
    private val observer = Observer<ViewState<MutableList<IpfsData>>> { handleResponse(it) }
    private lateinit var nftAdapter: NftAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = stakePoolViewModel
        setupNftAdapter(binding.nftRecyclerView)
    }

    private fun setupNftAdapter(nftRecyclerView: RecyclerView) {
        nftAdapter = NftAdapter()
        with(nftRecyclerView) {
            adapter = nftAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun handleResponse(it: ViewState<MutableList<IpfsData>>) {
        // TODO find out how to update the list adapter
//        when (it.state) {
//            SUCCESS -> bindData(it.data)
//            ERROR -> throw NotImplementedError()
//            LOADING -> throw NotImplementedError()
//        }
    }

//    private fun bindData(ipfsData : List<IpfsData>) {
//        nftAdapter.submit(ipfsData)
//    }

}