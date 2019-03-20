package com.example.myxan.vk_mvp.token;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;


public class TokenStorage{

    private static final String ARG_TOKEN = "token";
    @NonNull private final SharedPreferences prefs;
    private Gson gson;


    public TokenStorage(@NonNull SharedPreferences prefs, Gson gson) {
        this.prefs = prefs;
        this.gson = gson;
    }

    public void storeToken(@NonNull TokenModel tokenModel) {
        prefs.edit().putString(ARG_TOKEN, gson.toJson(tokenModel)).apply();
    }

    public TokenModel getToken() {
        return gson.fromJson(prefs.getString(ARG_TOKEN, null), TokenModel.class);
    }

    public void deleteToken() {
        prefs.edit().remove(ARG_TOKEN).apply();
    }

    public boolean tokenIsEmpty() {
        return !prefs.contains(ARG_TOKEN);
    }

}
