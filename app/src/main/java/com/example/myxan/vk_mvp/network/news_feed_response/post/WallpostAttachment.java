package com.example.myxan.vk_mvp.network.news_feed_response.post;

import com.example.myxan.vk_mvp.network.news_feed_response.attachments.Audio;
import com.example.myxan.vk_mvp.network.news_feed_response.attachments.Link;
import com.example.myxan.vk_mvp.network.news_feed_response.attachments.Photo;
import com.google.gson.annotations.SerializedName;

public class WallpostAttachment {

    @SerializedName("type") private  WallpostAttachmentType type;
    @SerializedName("photo") private Photo photo;
    @SerializedName("audio") private Audio audio;
    @SerializedName("link") private Link link;

    public WallpostAttachmentType getType() {
        return type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public Audio getAudio() {
        return audio;
    }

    public Link getLink() {
        return link;
    }
}
