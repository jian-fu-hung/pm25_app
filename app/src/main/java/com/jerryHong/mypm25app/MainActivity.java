package com.jerryHong.mypm25app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;
import com.jerryHong.mypm25app.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public RepoViewModel viewModel;

    private RepoAdapter repoAdapter = new RepoAdapter();

    private GithubViewModelFactory factory = new GithubViewModelFactory();

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
                viewModel.searchRepo();
            }
        });
        viewModel = ViewModelProviders.of(MainActivity.this,factory).get(RepoViewModel.class);
        binding.setViewModel(viewModel);
        mSwipeRefreshLayout = binding.refreshLayout;
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.searchRepo();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        viewModel.getRepo().observe(this, new Observer<List<RepoAQIResponse>>() {
            @Override
            public void onChanged(@Nullable List<RepoAQIResponse> repos) {
                repoAdapter.swapItems(repos);
            }
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(repoAdapter);
        viewModel.searchRepo();


    }
}
