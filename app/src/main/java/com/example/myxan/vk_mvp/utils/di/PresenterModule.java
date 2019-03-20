package com.example.myxan.vk_mvp.utils.di;

import com.example.myxan.vk_mvp.login.LoginPresenter;
import com.example.myxan.vk_mvp.news_feed.NewsFeedPresenter;
import com.example.myxan.vk_mvp.news_feed.NewsFeedModel;
import com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking.AdapterNetworkModel;
import com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking.AdapterNetworkPresenter;
import com.example.myxan.vk_mvp.token.TokenHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(TokenHolder tokenHolder) {
        return new LoginPresenter(tokenHolder);
    }

    @Provides
    @Singleton
    public NewsFeedPresenter provideNewsFeedPresenter(NewsFeedModel model, TokenHolder tokenHolder) {
        return new NewsFeedPresenter(model, tokenHolder);
    }

    @Provides
    public AdapterNetworkPresenter provideAdapterNetworkPresenter(AdapterNetworkModel model, TokenHolder tokenHolder){
        return new AdapterNetworkPresenter(model, tokenHolder);
    }
}
