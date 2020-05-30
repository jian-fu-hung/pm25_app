package com.jerryHong.mypm25app.data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jerryHong.mypm25app.RetrofitManager;
import com.jerryHong.mypm25app.api.OpenDataService;
import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel {

    private String TAG = "DataModel";

    private OpenDataService openDataService = RetrofitManager.getAPI();

    public void searchRepo(final onDataReadyCallback callback) {
        openDataService.searchRepos("0","76","json")
                .enqueue(new Callback<List<RepoAQIResponse>>() {
                    @Override
                    public void onResponse(Call<List<RepoAQIResponse>> call, Response<List<RepoAQIResponse>> response) {
                        callback.onDataReady(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<RepoAQIResponse>> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.toString());
                    }
                });
    }

    public interface onDataReadyCallback {
        void onDataReady(List<RepoAQIResponse> data);
    }
}
