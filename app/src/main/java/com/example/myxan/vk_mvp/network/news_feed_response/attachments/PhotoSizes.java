package com.example.myxan.vk_mvp.network.news_feed_response.attachments;

import com.google.gson.annotations.SerializedName;

public class PhotoSizes {


    @SerializedName("type") private String photoType;
    @SerializedName("url") private String photoUrl;
    @SerializedName("width") private int photoWidth;
    @SerializedName("height") private int photoHeight;

    public String getPhotoType() {
        return photoType;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public int getPhotoWidth() {
        return photoWidth;
    }

    public int getPhotoHeight() {
        return photoHeight;
    }
}
