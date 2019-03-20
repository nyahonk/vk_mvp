package com.example.myxan.vk_mvp.network.news_feed_response.general;

import com.google.gson.annotations.SerializedName;

public class RepostsInfo {

    @SerializedName("count") private int count;
    @SerializedName("user_reposted") private BoolInt userReposted;

    public int getCount() {
        return count;
    }

    public BoolInt getUserReposted() {
        return userReposted;
    }

}
