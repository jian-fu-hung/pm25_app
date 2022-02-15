package com.jerryHong.mypm25app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jerryHong.mypm25app.R
import com.jerryHong.mypm25app.RepoAdapter
import com.jerryHong.mypm25app.data.DataModel
import com.jerryHong.mypm25app.data.model.RepoAQIResponse
import com.jerryHong.mypm25app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val dataModel = DataModel()


    private val repoAdapter = RepoAdapter()
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(dataModel)
        ).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        initView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.searchRepoRX()
    }

    private fun initView() {
        binding.button.setOnClickListener { viewModel.searchRepoRX() }
        initList()
        initSwipeRefreshLayout()

        viewModel.isLoading.observe(this@MainActivity, object : Observer<Boolean> {
            override fun onChanged(isLoading: Boolean?) {
                isLoading?.let {
                    binding.refreshLayout.isRefreshing = it
                }
            }
        })

        viewModel.repoList.observe(this@MainActivity, object : Observer<List<RepoAQIResponse>> {
            override fun onChanged(list: List<RepoAQIResponse>?) {
                list?.let {
                    repoAdapter.setItem(it)
                }
            }
        })
    }

    private fun initList() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = repoAdapter
    }

    private fun initSwipeRefreshLayout() {
        mSwipeRefreshLayout = binding.refreshLayout
        mSwipeRefreshLayout.setOnRefreshListener { viewModel.searchRepoRX() }
    }
}