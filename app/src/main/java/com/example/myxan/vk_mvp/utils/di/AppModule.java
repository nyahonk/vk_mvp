package com.example.myxan.vk_mvp.utils.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.myxan.vk_mvp.network.API.AddLikeAPI;
import com.example.myxan.vk_mvp.network.API.NewsFeedAPI;
import com.example.myxan.vk_mvp.news_feed.NewsFeedModel;
import com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking.AdapterNetworkModel;
import com.example.myxan.vk_mvp.token.TokenHolder;
import com.example.myxan.vk_mvp.token.TokenStorage;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBGroupDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBPostDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBUserDao;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }



    @Provides
    @Singleton
    public TokenStorage provideTokenStorage(SharedPreferences prefs, Gson gson) {
        return new TokenStorage(prefs, gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public TokenHolder provideTokenHolder(TokenStorage storage) {
        return new TokenHolder(storage);
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
    }


    @Provides
    @Named("RetrofitNewsFeed")
    @Singleton
    public Retrofit provideRetrofitNewsfeed(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.vk.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NewsFeedAPI provideNewsFeedApi(@Named("RetrofitNewsFeed") Retrofit retrofit) {
        return retrofit.create(NewsFeedAPI.class);
    }

    @Provides
    @Singleton
    AddLikeAPI provideAddLikeApi(@Named("RetrofitNewsFeed") Retrofit retrofit) {
        return retrofit.create(AddLikeAPI.class);
    }

    @Provides
    @Singleton
    NewsFeedModel provideNewsFeedModel(NewsFeedAPI newsFeedAPI, TokenHolder tokenHolder, DBPostDao dbPostDao, DBUserDao dbUserDao, DBGroupDao dbGroupDao){
        return new NewsFeedModel(newsFeedAPI, tokenHolder, dbPostDao, dbUserDao, dbGroupDao);
    }

    @Provides
    @Singleton
    AdapterNetworkModel provideAdapterNetworkModel(AddLikeAPI addLikeAPI, TokenHolder tokenHolder){
        return new AdapterNetworkModel(addLikeAPI, tokenHolder);
    }

}
