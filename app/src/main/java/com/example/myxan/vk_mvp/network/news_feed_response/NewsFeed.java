package com.example.myxan.vk_mvp.network.news_feed_response;

import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsFeed {

    @SerializedName("items") public List<Post> posts;
    @SerializedName("profiles") public List<User> users;
    @SerializedName("groups") public List<Group> groups;
    @SerializedName("next_from") private String nextFrom;

    public List<Post> getPosts() {
        return posts;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getNextFrom() {
        return nextFrom;
    }
}


