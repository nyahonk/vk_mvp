package com.example.myxan.vk_mvp.utils.di;

import com.example.myxan.vk_mvp.login.LoginActivity;
import com.example.myxan.vk_mvp.login.LoginPresenter;
import com.example.myxan.vk_mvp.news_feed.NewsFeedActivity;
import com.example.myxan.vk_mvp.news_feed.adapter.NewsFeedAdapterHolder;
import com.example.myxan.vk_mvp.token.TokenHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, RoomModule.class})
public interface AppComponent {




    void inject(TokenHolder tokenHolder);
    void inject(LoginPresenter loginPresenter);
    void inject(LoginActivity loginActivity);
    void inject(NewsFeedActivity newsFeedActivity);
    void inject(NewsFeedAdapterHolder newsFeedAdapterHolder);



}
