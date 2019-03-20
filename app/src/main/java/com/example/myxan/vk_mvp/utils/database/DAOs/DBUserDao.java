package com.example.myxan.vk_mvp.utils.database.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.myxan.vk_mvp.utils.database.entities.DBUser;
import java.util.List;

@Dao
public interface DBUserDao {

    @Query("SELECT * FROM dbuser")
    List<DBUser> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DBUser dbUser);

    @Insert
    void insertAll(DBUser... DBUsers);

    @Query("DELETE FROM dbuser")
    void deleteAll();
}
