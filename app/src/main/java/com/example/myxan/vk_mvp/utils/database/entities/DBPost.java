package com.example.myxan.vk_mvp.utils.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DBPost {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "post")
    public String post;

    public DBPost(String post) {
        this.post = post;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
