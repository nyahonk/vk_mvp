package com.example.myxan.vk_mvp.utils.di;

import com.example.myxan.vk_mvp.App;
import com.example.myxan.vk_mvp.login.LoginActivity;
import com.example.myxan.vk_mvp.login.LoginPresenter;
import com.example.myxan.vk_mvp.news_feed.NewsFeedActivity;
import com.example.myxan.vk_mvp.news_feed.adapter.NewsFeedAdapterHolder;

public class Injector {


    public static void inject(LoginPresenter loginPresenter) {
        App.getAppComponent().inject(loginPresenter);
    }

    public static void inject(LoginActivity activity) {
        App.getAppComponent().inject(activity);
    }

    public static void inject(NewsFeedAdapterHolder activity) {
        App.getAppComponent().inject(activity);
    }
}
