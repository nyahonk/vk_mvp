package com.example.myxan.vk_mvp.news_feed.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.network.news_feed_response.attachments.PhotoSizes;
import com.example.myxan.vk_mvp.network.news_feed_response.post.WallpostAttachment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttachmentsAdapterHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.attachment_place_holder_0)
    ImageView attachment_place_holder_0;

    private int height = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int width = Resources.getSystem().getDisplayMetrics().widthPixels;


    public AttachmentsAdapterHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(WallpostAttachment attachment) {

        switch (attachment.getType()) {
            case PHOTO:
                        setPhoto(attachment.getPhoto().getPhotoSizes().get(getSuitablePhotoSize(attachment.getPhoto().getPhotoSizes())));
        }
    }

    private void setPhoto(PhotoSizes photoItem) {
        Glide.with(itemView.getContext())
                .asBitmap()
                .load(photoItem.getPhotoUrl())
                .apply(new RequestOptions().override(width - 80, 200))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        attachment_place_holder_0.setImageBitmap(resource);
                    }
                });
    }

    private int getSuitablePhotoSize(List<PhotoSizes> photoSizes) {
        int size = 0;
        int index = 0;
        for (int i = 0; i < photoSizes.size(); i++) {
            if (photoSizes.get(i).getPhotoWidth() > size /*&& photoSizes.get(i).getPhotoWidth() <= width*/) {
                size = photoSizes.get(i).getPhotoWidth();
                index = i;
            }
        }
        return index;
    }
}
