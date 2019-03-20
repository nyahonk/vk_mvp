package com.example.myxan.vk_mvp.network.news_feed_response.group;

import com.google.gson.annotations.SerializedName;

public enum GroupType {

    @SerializedName("group")GROUP("group"),
    @SerializedName("page")PAGE("page"),
    @SerializedName("event")EVENT("event");

    private final String value;

    GroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
