package com.example.myxan.vk_mvp.utils.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DBGroup {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "group")
    public String group;

    public DBGroup(int uid, String group) {
        this.uid = uid;
        this.group = group;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
