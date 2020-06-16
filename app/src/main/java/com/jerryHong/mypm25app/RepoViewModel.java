package com.jerryHong.mypm25app;

import com.jerryHong.mypm25app.base.BaseViewModel;
import com.jerryHong.mypm25app.data.DataModel;
import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;
import com.jerryHong.mypm25app.main.MainContract;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoViewModel extends BaseViewModel implements MainContract.Presenter {

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final MutableLiveData<List<RepoAQIResponse>> repos = new MutableLiveData<>();

    private List<RepoAQIResponse> repoAQIResponses = new ArrayList<>();

    private DataModel dataModel;

    private RepoAdapter repoAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    public RepoViewModel(DataModel dataModel) {
        super();
        this.dataModel = dataModel;
    }

    LiveData<List<RepoAQIResponse>> getRepo(){
        return repos;
    }

    @Override
    public void setAdapter(RepoAdapter adapter) {
        this.repoAdapter = adapter;
    }

    @Override
    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    public void searchRepoRX() {
//        isLoading.set(true);
        swipeRefreshLayout.setRefreshing(true);
        addDisposable(dataModel.searchRepoRX()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<RepoAQIResponse>>() {
                    @Override
                    public void onSuccess(List<RepoAQIResponse> repoAQIResponses) {
                        repoAdapter.swapItems(repoAQIResponses);
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }));
    }

}
