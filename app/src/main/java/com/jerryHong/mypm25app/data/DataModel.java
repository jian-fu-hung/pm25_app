package com.jerryHong.mypm25app;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jerryHong.mypm25app.api.OpenDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel {

    private String TAG = "DataModel";

    private OpenDataService openDataService = RetrofitManager.getAPI();

    public void searchRepo(final onDataReadyCallback callback) {
        openDataService.searchRepos()
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
                        Log.d(TAG, "onResponse: "+jsonObject.getAsString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }

    public interface onDataReadyCallback {
        void onDataReady(List<RepoGetResponse> data);
    }
}
