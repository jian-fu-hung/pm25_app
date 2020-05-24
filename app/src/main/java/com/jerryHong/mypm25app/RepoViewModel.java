package com.jerryHong.mypm25app;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RepoViewModel extends ViewModel {

    public final ObservableField<String> mData = new ObservableField<>();

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final MutableLiveData<String> repos = new MutableLiveData<>();

    private DataModel dataModel = new DataModel();

    LiveData<String> getRepo(){
        return repos;
    }

    void searchRepo(String query){
        isLoading.set(true);

        dataModel.getPMRepo(query, new DataModel.onDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                isLoading.set(false);
                repos.setValue(data);
            }
        });
    }

}
