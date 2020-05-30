package com.jerryHong.mypm25app;

import com.jerryHong.mypm25app.data.DataModel;
import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;

import java.util.List;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RepoViewModel extends ViewModel {

    public final ObservableField<String> mData = new ObservableField<>();

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final MutableLiveData<List<RepoAQIResponse>> repos = new MutableLiveData<>();

    private DataModel dataModel;

    public RepoViewModel(DataModel dataModel) {
        super();
        this.dataModel = dataModel;
    }

    LiveData<List<RepoAQIResponse>> getRepo(){
        return repos;
    }

    void searchRepo(){
        isLoading.set(true);

        dataModel.searchRepo(new DataModel.onDataReadyCallback() {
            @Override
            public void onDataReady(List<RepoAQIResponse> data) {
                isLoading.set(false);
                repos.setValue(data);
            }
        });
    }

}
