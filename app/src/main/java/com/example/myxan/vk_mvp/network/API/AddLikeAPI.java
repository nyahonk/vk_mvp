package com.example.myxan.vk_mvp.network.API;

import android.support.annotation.Nullable;
import com.example.myxan.vk_mvp.network.LikeResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AddLikeAPI {

    String METHOD   = "/method/";

    @GET(METHOD + "likes.add")
    Observable<LikeResponse> getAddLike(
            @Query("type") @Nullable String post,
            @Query("owner_id") @Nullable String ownerId,
            @Query("item_id") @Nullable String itemId,
            @Query("access_token") @Nullable String token,
            @Query("v") @Nullable String version
    );

    @GET(METHOD + "likes.delete")
    Observable<LikeResponse> getDeleteLike(
            @Query("type") @Nullable String post,
            @Query("owner_id") @Nullable String ownerId,
            @Query("item_id") @Nullable String itemId,
            @Query("access_token") @Nullable String token,
            @Query("v") @Nullable String version
    );
}
