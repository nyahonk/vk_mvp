package com.example.myxan.vk_mvp.network.news_feed_response.user;

import com.google.gson.annotations.SerializedName;

public enum  Sex {

    @SerializedName("1")FEMALE(1),
    @SerializedName("2")MALE(2),
    @SerializedName("0")UNKNOWN(0);

    private final int value;

    Sex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
