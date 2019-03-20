package com.example.myxan.vk_mvp.network.news_feed_response.user;

import android.support.annotation.NonNull;

import com.example.myxan.vk_mvp.network.news_feed_response.Poster;
import com.example.myxan.vk_mvp.network.news_feed_response.general.BoolInt;
import com.google.gson.annotations.SerializedName;

public class User extends Poster {

    @SerializedName("first_name") private String  firstName;
    @SerializedName("last_name") private String  secondName;
    @SerializedName("sex") private Sex sex;
    @SerializedName("online") private BoolInt online;

    @NonNull
    @Override public String getDisplayName() {
        return (firstName == null ? "" : firstName) + " " + (secondName == null ? "" : secondName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Sex getSex() {
        return sex;
    }

    public BoolInt getOnline() {
        return online;
    }
}
