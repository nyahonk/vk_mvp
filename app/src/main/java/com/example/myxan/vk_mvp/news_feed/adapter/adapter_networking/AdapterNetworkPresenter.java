package com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking;

import android.content.Context;
import android.widget.Toast;
import com.example.myxan.vk_mvp.token.TokenHolder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AdapterNetworkPresenter {

    protected AdapterNetworkView view;
    private AdapterNetworkModel model;
    private TokenHolder tokenHolder;

    private CompositeDisposable disposables = new CompositeDisposable();

    public AdapterNetworkPresenter(AdapterNetworkModel model, TokenHolder tokenHolder) {
        this.model = model;
        this.tokenHolder = tokenHolder;
    }

    public void addLike(int ownerId, int postId, Context context) {
        disposables.add(model.addLike(ownerId, postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(likeResponse -> view.setLike(likeResponse)
                        , ignoreError -> {
            Toast.makeText(context, "network error", Toast.LENGTH_SHORT).show();
            //todo implement errorhandling
        }));
    }

    public void addDislike(int ownerId, int postId, Context context) {
        disposables.add(model.deleteLike(ownerId, postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(likeResponse -> view.setDislike(likeResponse)
                        , ignoreError -> {
                            Toast.makeText(context, "network error", Toast.LENGTH_SHORT).show();
                            //todo implement errorhandling
                        }));
    }

    public void attach(AdapterNetworkView view) {
        this.view = view;
    }

    public void deatch() {
        disposables.dispose();
        this.view = null;
    }
}
