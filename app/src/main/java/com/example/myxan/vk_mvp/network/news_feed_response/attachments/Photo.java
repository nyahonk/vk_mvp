package com.example.myxan.vk_mvp.network.news_feed_response.attachments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("id") private int id;
    @SerializedName("album_id") private int albumId;
    @SerializedName("owner_id") private int ownerId;
    @SerializedName("user_id") private int userId;
    @SerializedName("post_id") private int postId;
    @SerializedName("width") private  int width;
    @SerializedName("height") private int height;
    @SerializedName("text") private String text;
    @SerializedName("date") private long date;
    @SerializedName("lat") private float lat;
    @SerializedName("long") private float lng;
    @SerializedName("access_key") private String accessKey;
    @SerializedName("sizes") private List<PhotoSizes> photoSizes;

    public int getId() {
        return id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getUserId() {
        return userId;
    }


    public int getPostId() {
        return postId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public List<PhotoSizes> getPhotoSizes() {
        return photoSizes;
    }
}
