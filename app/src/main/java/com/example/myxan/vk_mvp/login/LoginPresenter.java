package com.example.myxan.vk_mvp.login;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.myxan.vk_mvp.token.TokenHolder;
import com.example.myxan.vk_mvp.utils.TokenFromUrl;


public class LoginPresenter {

    protected LoginView view;
    private TokenHolder tokenHolder;

    private static final String PARAM_USER_ID      = "user_id";
    private static final String PARAM_ACCESS_TOKEN = "access_token";

    public LoginPresenter(@NonNull TokenHolder tokenHolder) {
        this.tokenHolder = tokenHolder;
    }

    public void attach(LoginView view){
        this.view = view;
    }

    public void detach(){
        this.view = null;
    }

    public boolean isLoggedIn(@Nullable String responseUrl) {
        if (responseUrl != null &&
                responseUrl.contains(PARAM_USER_ID) &&
                responseUrl.contains(PARAM_ACCESS_TOKEN)) {
                saveToken(responseUrl);

            return true;
        }
        return false;
    }

    private void saveToken(@NonNull String responseUrl) {
        String userId = TokenFromUrl.getParamValueFromUrl(responseUrl, "user_id");
        String token = TokenFromUrl.getParamValueFromUrl(responseUrl, "access_token");
        tokenHolder.saveSession(token, userId);


        if (view != null) {
            view.showNewsFeed();
            detach();
        }
    }


}
