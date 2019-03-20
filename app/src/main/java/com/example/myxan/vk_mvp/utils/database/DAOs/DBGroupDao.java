package com.example.myxan.vk_mvp.utils.database.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.myxan.vk_mvp.utils.database.entities.DBGroup;
import java.util.List;

@Dao
public interface DBGroupDao {

    @Query("SELECT * FROM dbgroup")
    List<DBGroup> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DBGroup dbGroup);

    @Insert
    void insertAll(DBGroup... dbGroups);

    @Query("DELETE FROM dbgroup")
    void deleteAll();
}
