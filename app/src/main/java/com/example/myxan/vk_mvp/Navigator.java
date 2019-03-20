package com.example.myxan.vk_mvp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.myxan.vk_mvp.login.LoginActivity;
import com.example.myxan.vk_mvp.news_feed.NewsFeedActivity;

public class Navigator {

    public static void showNewsFeed(@NonNull Context context) {
        context.startActivity(new Intent(context, NewsFeedActivity.class));
    }

    public static void showLoginActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
