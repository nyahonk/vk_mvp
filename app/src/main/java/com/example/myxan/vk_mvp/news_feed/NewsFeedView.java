package com.example.myxan.vk_mvp.news_feed;

import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;

import java.util.List;

public interface NewsFeedView {

    void showNewsFeed(List<Post> posts, List<User> users, List<Group> groups);
    void loadMoreItems(int newItemsCount);
    void showLogin();
}
