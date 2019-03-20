package com.example.myxan.vk_mvp.network.news_feed_response.attachments;

import com.google.gson.annotations.SerializedName;

public class Audio {

    @SerializedName("id") private int id;
    @SerializedName("owner_id") private int ownerId;
    @SerializedName("artist") private String artist;
    @SerializedName("title") private String title;
    @SerializedName("url") private String url;
    @SerializedName("access_key") private String accessKey;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAccessKey() {
        return accessKey;
    }

}
