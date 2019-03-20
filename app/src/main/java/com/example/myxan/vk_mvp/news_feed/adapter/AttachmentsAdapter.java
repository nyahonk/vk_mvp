package com.example.myxan.vk_mvp.news_feed.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.network.news_feed_response.post.WallpostAttachment;

import java.util.List;

public class AttachmentsAdapter extends RecyclerView.Adapter<AttachmentsAdapterHolder> {

    private Context context;
    private List<WallpostAttachment> attachments;

    @NonNull
    @Override
    public AttachmentsAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.attachment_rv_photo, parent, false);
        return new AttachmentsAdapterHolder(itemView);
    }

    public AttachmentsAdapter(Context context, List<WallpostAttachment> attachments) {
        this.context = context;
        this.attachments = attachments;
    }

    @Override
    public void onBindViewHolder(@NonNull AttachmentsAdapterHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.bind(attachments.get(position));
    }

    @Override
    public int getItemCount() {
        return attachments.size();
    }
}
