package com.example.myxan.vk_mvp.token;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.HashMap;

public class TokenHolder {

    @NonNull private final TokenStorage storage;

    public TokenHolder(@NonNull TokenStorage storage) {
        this.storage = storage;
    }

    public void saveSession(@NonNull String accessToken, @NonNull String userId) {
        storage.storeToken(new TokenModel(accessToken, userId));
    }

    public String getToken() {
     return storage.getToken().getAccessToken();
    }

    public String getUserId() {
        return storage.getToken().getUserId();
    }

    public void clean() {
        storage.deleteToken();
    }


    public boolean isUserAuthorized() {
        return !storage.tokenIsEmpty();
    }

}
