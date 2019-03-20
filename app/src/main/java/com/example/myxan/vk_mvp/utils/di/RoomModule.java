package com.example.myxan.vk_mvp.utils.di;

import android.content.Context;

import com.example.myxan.vk_mvp.utils.database.AppDatabase;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBGroupDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBPostDao;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBUserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context){
        return AppDatabase.getInstance(context);
    }

    @Provides
    @Singleton
    DBPostDao provideDBPostDao(AppDatabase db){
        return db.dbPostDao();
    }

    @Provides
    @Singleton
    DBUserDao provideDBUserDao(AppDatabase db){
        return db.dbUserDao();
    }

    @Provides
    @Singleton
    DBGroupDao provideDBGroupDao(AppDatabase db){
        return db.dbGroupDao();
    }
}
