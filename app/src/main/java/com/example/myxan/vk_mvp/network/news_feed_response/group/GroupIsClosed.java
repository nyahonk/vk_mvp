package com.example.myxan.vk_mvp.network.news_feed_response.group;

import com.google.gson.annotations.SerializedName;

public enum GroupIsClosed {

    @SerializedName("0")OPEN(0),
    @SerializedName("1")CLOSED(1),
    @SerializedName("2")PRIVATE(2);

    private final int value;

    GroupIsClosed(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
