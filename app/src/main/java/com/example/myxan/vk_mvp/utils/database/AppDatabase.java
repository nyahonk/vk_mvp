package com.example.myxan.vk_mvp.utils.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.myxan.vk_mvp.utils.database.entities.DBGroup;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBGroupDao;
import com.example.myxan.vk_mvp.utils.database.entities.DBPost;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBPostDao;
import com.example.myxan.vk_mvp.utils.database.entities.DBUser;
import com.example.myxan.vk_mvp.utils.database.DAOs.DBUserDao;

@Database(entities = {DBPost.class, DBUser.class, DBGroup.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;
    public abstract DBPostDao dbPostDao();
    public abstract DBGroupDao dbGroupDao();
    public abstract DBUserDao dbUserDao();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"app_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return sInstance;
    }

}
