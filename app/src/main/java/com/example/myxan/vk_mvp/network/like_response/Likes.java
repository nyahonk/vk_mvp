package com.example.myxan.vk_mvp.network.like_response;

import com.google.gson.annotations.SerializedName;

public class Likes {

    @SerializedName("likes") int likesCount;

    public int getLikesCount() {
        return likesCount;
    }
}
