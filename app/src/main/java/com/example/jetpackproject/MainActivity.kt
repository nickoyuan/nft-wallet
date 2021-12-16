package com.example.jetpackproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val stakePoolViewModel by viewModels<StakePoolViewModel> {
        StakePoolViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupNftAdapter(binding.nftRecyclerView)
    }

    private fun setupNftAdapter(nftRecyclerView: RecyclerView) {
        with(nftRecyclerView) {
            adapter = NftAdapter()
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onResume() {
        super.onResume()
        stakePoolViewModel.fetchWallets()
    }

}