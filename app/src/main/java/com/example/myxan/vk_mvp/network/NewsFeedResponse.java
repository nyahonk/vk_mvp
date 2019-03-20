package com.example.myxan.vk_mvp.network;

import com.example.myxan.vk_mvp.network.news_feed_response.NewsFeed;
import com.google.gson.annotations.SerializedName;

public class NewsFeedResponse {

    @SerializedName("response") private NewsFeed newsFeed;

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

}
