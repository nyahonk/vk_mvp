package com.example.myxan.vk_mvp.network.news_feed_response.general;

import com.google.gson.annotations.SerializedName;

public class ViewsInfo {

    @SerializedName("count") private int count;

    public int getCount() {
        return count;
    }

}
