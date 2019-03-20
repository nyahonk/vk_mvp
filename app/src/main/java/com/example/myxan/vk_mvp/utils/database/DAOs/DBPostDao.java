package com.example.myxan.vk_mvp.utils.database.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.myxan.vk_mvp.utils.database.entities.DBPost;
import java.util.List;
import io.reactivex.Single;

@Dao
public interface DBPostDao {

    @Query("SELECT * FROM dbpost")
    List<DBPost> getAll();

    @Query("SELECT * FROM dbpost")
    Single<List<DBPost>> getAllPosts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DBPost dbPost);

    @Insert
    void insertAll(DBPost... DBPosts);

    @Query("DELETE FROM dbpost")
    void deleteAll();
}
