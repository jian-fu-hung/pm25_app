package com.jerryHong.mypm25app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;
import com.jerryHong.mypm25app.databinding.ActivityMainBinding;
import com.jerryHong.mypm25app.main.MainContract;

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
                viewModel.searchRepoRX();
            }
        });
        viewModel = ViewModelProviders.of(MainActivity.this,factory).get(RepoViewModel.class);

        binding.setViewModel(viewModel);

        initList();

        initSwipeRefreshLayout();

        viewModel.searchRepoRX();
    }

    private void initList(){
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(repoAdapter);
        viewModel.setAdapter(repoAdapter);
    }

    private void initSwipeRefreshLayout(){
        mSwipeRefreshLayout = binding.refreshLayout;
        viewModel.setSwipeRefreshLayout(mSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.searchRepoRX();
            }
        });
    }
}
