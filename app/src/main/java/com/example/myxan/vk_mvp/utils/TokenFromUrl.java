package com.example.myxan.vk_mvp.utils;

import android.support.annotation.NonNull;

public class TokenFromUrl {

    @NonNull
    public static String getParamValueFromUrl(@NonNull String url, @NonNull String param) {
        return url
                .replaceAll(".*" + param + "=", "")
                .replaceAll("&.*", "");
    }

}
