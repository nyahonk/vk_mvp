package com.example.myxan.vk_mvp.network.news_feed_response.general;

import com.google.gson.annotations.SerializedName;

public class CommentsInfo {

    @SerializedName("count") private int count;
    @SerializedName("can_post") private BoolInt canPost;

    public int getCount() {
        return count;
    }

    public BoolInt getCanPost() {
        return canPost;
    }

}
