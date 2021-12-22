package com.jerryHong.mypm25app.api;

import com.jerryHong.mypm25app.data.model.RepoAQIHeaderResponse;
import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenDataService {
    @GET("/api/v1/aqx_p_432")
    Call<List<RepoAQIResponse>> searchRepos(@Query("format") String format, @Query("limit") String limit, @Query("api_key") String apiKey);

    @GET("/api/v1/aqx_p_432")
    Single<RepoAQIHeaderResponse<List<RepoAQIResponse>>> searchReposRX(@Query("format") String format, @Query("limit") String limit, @Query("api_key") String apiKey);
}
