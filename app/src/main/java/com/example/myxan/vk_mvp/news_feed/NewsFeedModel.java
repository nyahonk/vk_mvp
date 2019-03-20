package com.example.myxan.vk_mvp.news_feed;

import com.example.myxan.vk_mvp.network.API.NewsFeedAPI;
import com.example.myxan.vk_mvp.network.NewsFeedResponse;
import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;
import com.example.myxan.vk_mvp.token.TokenHolder;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBGroupDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBPostDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBUserDao;
import com.example.myxan.vk_mvp.utils.database.entities.DBGroup;
import com.example.myxan.vk_mvp.utils.database.entities.DBPost;
import com.example.myxan.vk_mvp.utils.database.entities.DBUser;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsFeedModel {

    private NewsFeedAPI api;
    private TokenHolder tokenHolder;
    private DBGroupDao dbGroupDao;
    private DBPostDao dbPostDao;
    private DBUserDao dbUserDao;

    private Gson gson = new Gson();

    public NewsFeedModel(NewsFeedAPI api, TokenHolder tokenHolder, DBPostDao dbPostDao, DBUserDao dbUserDao, DBGroupDao dbGroupDao) {
        this.api = api;
        this.tokenHolder = tokenHolder;
        this.dbGroupDao = dbGroupDao;
        this.dbPostDao = dbPostDao;
        this.dbUserDao = dbUserDao;
    }

    public Observable<NewsFeedResponse> getNewsFeedPosts(String startFrom, int quantity, boolean newSession) {

        return api.getNewsFeed(tokenHolder.getToken(), "post", quantity, startFrom, "5.87").map((response) -> {

            if (newSession) {
                Completable.fromRunnable(() -> {
                    dbPostDao.deleteAll();
                    dbGroupDao.deleteAll();
                    dbUserDao.deleteAll();
                }).subscribeOn(Schedulers.io()).subscribe();
            }

            for (int i = 0; i < response.getNewsFeed().getPosts().size(); i++) {
                DBPost dbPost = new DBPost(gson.toJson(response.getNewsFeed().getPosts().get(i)));
                Completable.fromRunnable(() -> dbPostDao.insert(dbPost)).subscribeOn(Schedulers.io()).subscribe();
            }

            for (int i = 0; i < response.getNewsFeed().getUsers().size(); i++) {
                DBUser dbUser = new DBUser(response.getNewsFeed().getUsers().get(i).getId(), gson.toJson(response.getNewsFeed().getUsers().get(i)));
                Completable.fromRunnable(() -> dbUserDao.insert(dbUser)).subscribeOn(Schedulers.io()).subscribe();
            }

            for (int i = 0; i < response.getNewsFeed().getGroups().size(); i++) {
                DBGroup dbGroup = new DBGroup(response.getNewsFeed().getGroups().get(i).getId(), gson.toJson(response.getNewsFeed().getGroups().get(i)));
                Completable.fromRunnable(() -> dbGroupDao.insert(dbGroup)).subscribeOn(Schedulers.io()).subscribe();
            }
            return response;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public List<Post> getPostsFromDB() {

        List<Post> posts = new ArrayList<>();
        List<DBPost> dbPosts = dbPostDao.getAll();
        for (int i = 0; i < dbPosts.size(); i++) {
            posts.add(gson.fromJson(dbPosts.get(i).getPost(), Post.class));
        }
        return posts;
    }


    public List<Group> getGroupsFromDB() {

        List<Group> groups = new ArrayList<>();
        List<DBGroup> dbGroups = dbGroupDao.getAll();
        for (int i = 0; i < dbGroups.size(); i++) {
            groups.add(gson.fromJson(dbGroups.get(i).getGroup(), Group.class));
        }
        return groups;
    }

    public List<User> getUsersFromDB() {

        List<User> users = new ArrayList<>();
        List<DBUser> dbUsers = dbUserDao.getAll();
        for (int i = 0; i < dbUsers.size(); i++) {
            users.add(gson.fromJson(dbUsers.get(i).getUser(), User.class));
        }
        return users;
    }



}
