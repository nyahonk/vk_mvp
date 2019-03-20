package com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking;

import com.example.myxan.vk_mvp.network.API.AddLikeAPI;
import com.example.myxan.vk_mvp.network.LikeResponse;
import com.example.myxan.vk_mvp.network.NewsFeedResponse;
import com.example.myxan.vk_mvp.token.TokenHolder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AdapterNetworkModel {

    private AddLikeAPI api;
    private TokenHolder tokenHolder;

    public AdapterNetworkModel(AddLikeAPI api, TokenHolder tokenHolder) {
        this.api = api;
        this.tokenHolder = tokenHolder;
    }

    public Observable<LikeResponse> addLike(int ownerId, int postId) {
        return api.getAddLike("post", String.valueOf(ownerId), String.valueOf(postId), tokenHolder.getToken(), "5.87")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<LikeResponse> deleteLike(int ownerId, int postId) {
        return api.getDeleteLike("post", String.valueOf(ownerId), String.valueOf(postId), tokenHolder.getToken(), "5.87")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
