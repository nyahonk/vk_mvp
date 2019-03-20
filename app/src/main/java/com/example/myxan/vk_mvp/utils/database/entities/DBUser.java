package com.example.myxan.vk_mvp.utils.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DBUser {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "user")
    public String user;

    public DBUser(int uid, String user) {
        this.uid = uid;
        this.user = user;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
