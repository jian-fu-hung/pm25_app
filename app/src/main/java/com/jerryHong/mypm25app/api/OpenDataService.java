package com.jerryHong.mypm25app.api;

import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenDataService {
    @GET("/webapi/Data/ATM00679/")
    Call<List<RepoAQIResponse>> searchRepos(@Query("$skip") String skip, @Query("$top") String top, @Query("format") String format);

    @GET("/webapi/Data/ATM00679/")
    Single<List<RepoAQIResponse>> searchReposRX(@Query("$skip") String skip, @Query("$top") String top, @Query("format") String format);
}
