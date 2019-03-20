package com.example.myxan.vk_mvp.network;

import com.example.myxan.vk_mvp.network.like_response.Likes;
import com.google.gson.annotations.SerializedName;

public class LikeResponse {

    @SerializedName("response") private Likes likes;

    public Likes getLikes() {
        return likes;
    }
}
