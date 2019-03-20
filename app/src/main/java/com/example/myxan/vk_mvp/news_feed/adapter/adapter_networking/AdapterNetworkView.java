package com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking;

import com.example.myxan.vk_mvp.network.LikeResponse;

public interface AdapterNetworkView {

    void setLike(LikeResponse likeResponse);
    void setDislike(LikeResponse likeResponse);
}
