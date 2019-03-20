package com.example.myxan.vk_mvp.token;

import com.google.gson.annotations.SerializedName;

public class TokenModel {

    @SerializedName("access_token") private String accessToken;
    @SerializedName("user_id") private String userId;

    public TokenModel(String accessToken, String userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
