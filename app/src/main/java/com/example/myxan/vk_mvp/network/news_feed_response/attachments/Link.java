package com.example.myxan.vk_mvp.network.news_feed_response.attachments;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("url") private String url;
    @SerializedName("title") private String title;
    @SerializedName("caption") private String caption;
    @SerializedName("description") private String description;
    @SerializedName("photo") private Photo photo;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public Photo getPhoto() {
        return photo;
    }

}
