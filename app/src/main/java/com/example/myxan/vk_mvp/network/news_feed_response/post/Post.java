package com.example.myxan.vk_mvp.network.news_feed_response.post;

import com.example.myxan.vk_mvp.network.news_feed_response.general.CommentsInfo;
import com.example.myxan.vk_mvp.network.news_feed_response.general.LikesInfo;
import com.example.myxan.vk_mvp.network.news_feed_response.general.RepostsInfo;
import com.example.myxan.vk_mvp.network.news_feed_response.general.ViewsInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("type") private String postType;
    @SerializedName("post_id") private int postId;
    @SerializedName("source_id") private int sourceId;
    @SerializedName("text") private String text;
    @SerializedName("date") private long date;
    @SerializedName("copy_history") private List<Wallpost> copyHistory;
    @SerializedName("attachments") private List<WallpostAttachment> attachments;
    @SerializedName("comments") private CommentsInfo comments;
    @SerializedName("likes") private LikesInfo likes;
    @SerializedName("reposts") private RepostsInfo reposts;
    @SerializedName("views") private ViewsInfo views;

    public String getPostType() {return postType;}

    public int getPostId() {
        return postId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public List<Wallpost> getCopyHistory() {
        return copyHistory;
    }

    public List<WallpostAttachment> getAttachments() {
        return attachments;
    }

    public CommentsInfo getComments() {
        return comments;
    }

    public LikesInfo getLikes() {
        return likes;
    }

    public RepostsInfo getReposts() {
        return reposts;
    }

    public ViewsInfo getViews() {
        return views;
    }
}
