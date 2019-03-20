package com.example.myxan.vk_mvp.network.API;

import android.support.annotation.Nullable;

import com.example.myxan.vk_mvp.network.NewsFeedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsFeedAPI {

    String METHOD   = "/method/";

    @GET(METHOD + "newsfeed.get")
    Observable<NewsFeedResponse> getNewsFeed(
            @Query("access_token") @Nullable String token,
            @Query("filters") @Nullable String filters,
            @Query("count") int count,
            @Query("start_from") @Nullable String startFrom,
            @Query("v") @Nullable String version
    );
}
