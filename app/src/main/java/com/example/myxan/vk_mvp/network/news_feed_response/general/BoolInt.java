package com.example.myxan.vk_mvp.network.news_feed_response.general;

import com.google.gson.annotations.SerializedName;

public enum BoolInt {

    @SerializedName("0")NO(0),
    @SerializedName("1")YES(1);

    private final int value;

    BoolInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
