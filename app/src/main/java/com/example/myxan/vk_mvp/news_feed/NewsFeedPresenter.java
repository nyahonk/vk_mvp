package com.example.myxan.vk_mvp.news_feed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.example.myxan.vk_mvp.network.NewsFeedResponse;
import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;
import com.example.myxan.vk_mvp.token.TokenHolder;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.disposables.Disposable;

public class NewsFeedPresenter {

    protected NewsFeedView view;
    private NewsFeedModel model;
    private TokenHolder tokenHolder;

    private Disposable disposables;

    @NonNull private List<Post> posts  = new ArrayList<>();
    @NonNull private List<User>  users  = new ArrayList<>();
    @NonNull private List<Group> groups = new ArrayList<>();
    @Nullable private String nextFrom;
    private int itemsLoadCount = 15;

    private boolean newPostsLoading = true;
    private boolean newSession = true;

    public NewsFeedPresenter(@NonNull NewsFeedModel model, TokenHolder tokenHolder) {
        this.model = model;
        this.tokenHolder = tokenHolder;
    }

    public boolean isLoggedIn(){
        return tokenHolder.isUserAuthorized();
    }

    public void loadNewsFeed(Context context) {
        if (disposables == null) {
            disposables = model.getNewsFeedPosts("0", itemsLoadCount, newSession)
                    .doAfterTerminate(() -> disposables = null)
                    .subscribe(newsFeedResponse -> {
                        refreshLists(newsFeedResponse);
                        view.showNewsFeed(posts, users, groups);
                        newPostsLoading = false;
                        newSession = false;
                    }, ignoreError -> {
                        setListsFromDb();
                        view.showNewsFeed(posts, users, groups);
                        Toast.makeText(context, "No network connection", Toast.LENGTH_SHORT).show();
                        //todo implement errorhandling
                    });
        }
    }


    public void setListsFromDb(){
            posts = model.getPostsFromDB();
            posts.size();
            groups = model.getGroupsFromDB();
            users = model.getUsersFromDB();
    }

    public void tryPaginate(int currentPosition) {
        if (currentPosition + 5 > posts.size()) {
            if(!newPostsLoading) {
                loadMore(nextFrom);
            }
        }
    }

    private void refreshLists(@Nullable NewsFeedResponse newsFeedResponse) {
        clearLists();
        addLists(newsFeedResponse);

        if (view != null) {
            view.showNewsFeed(posts, users, groups);
        }
    }

    private void clearLists() {
        posts.clear();
        users.clear();
        groups.clear();
    }

    private void addLists(@Nullable NewsFeedResponse newsFeedResponse) {
        if (newsFeedResponse != null) {
            posts.addAll(newsFeedResponse.getNewsFeed().getPosts());
            users.addAll(newsFeedResponse.getNewsFeed().getUsers());
            groups.addAll(newsFeedResponse.getNewsFeed().getGroups());
            nextFrom = newsFeedResponse.getNewsFeed().getNextFrom();
        }
    }

    public void loadMore(String nextFrom) {
        newPostsLoading = true;
        disposables = model.getNewsFeedPosts(nextFrom, itemsLoadCount, newSession)
                .doAfterTerminate(() -> {
                    disposables = null;
                    newPostsLoading = false;
                })
                .subscribe(newsFeedResponse -> {
                    addLists(newsFeedResponse);
                    view.loadMoreItems(itemsLoadCount);
                        },
                        ignoreError -> {
                            //todo implement errorhandling
                        });
    }

    public void onLogoutClicked() {
        tokenHolder.clean();
        detach();
    }



    public void attach(NewsFeedView view){
        this.view = view;
    }

    public void detach(){
        disposables = null;
        this.view = null;
    }

}
