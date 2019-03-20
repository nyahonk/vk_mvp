package com.example.myxan.vk_mvp.network.news_feed_response.post;

import com.google.gson.annotations.SerializedName;

public enum WallpostAttachmentType {

    @SerializedName("photo")PHOTO("photo"),
    @SerializedName("audio")AUDIO("audio"),
    @SerializedName("video")VIDEO("video"),
    @SerializedName("doc")DOC("doc"),
    @SerializedName("link")LINK("link"),
    @SerializedName("poll")POLL("poll");

    private final String value;

    WallpostAttachmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
