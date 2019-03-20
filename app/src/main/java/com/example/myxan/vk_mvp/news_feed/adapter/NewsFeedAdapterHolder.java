package com.example.myxan.vk_mvp.news_feed.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.network.LikeResponse;
import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;
import com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking.AdapterNetworkPresenter;
import com.example.myxan.vk_mvp.news_feed.adapter.adapter_networking.AdapterNetworkView;
import com.example.myxan.vk_mvp.utils.di.Injector;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class NewsFeedAdapterHolder extends RecyclerView.ViewHolder implements AdapterNetworkView {

    @Inject
    AdapterNetworkPresenter presenter;

    @BindView(R.id.post_title) TextView postTitle;
    @BindView(R.id.post_description) TextView postDescription;
    @BindView(R.id.likes_count) TextView likeCount;
    @BindView(R.id.repost_count) TextView repostCount;
    @BindView(R.id.comment_count) TextView commentCount;
    @BindView(R.id.views_count) TextView viewCount;
    @BindView(R.id.post_date) TextView postDate;
    @BindView(R.id.post_avatar) CircleImageView postAvatar;
    @BindView(R.id.like_icon) ImageView likeIcon;
    @BindView(R.id.repost_avatar) CircleImageView repostAvatar;
    @BindView(R.id.repost_title) TextView repostTitle;
    @BindView(R.id.repost_date) TextView repostDate;
    @BindView(R.id.repost_description) TextView repostDescription;


    @BindView(R.id.attachment_recycler_view) RecyclerView attRecyclerView;
    LinearLayoutManager attLayoutManager;

    private int userLike;
    private int postId;
    private int ownerId;



    public NewsFeedAdapterHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        Injector.inject(this);
        attLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        attRecyclerView.setLayoutManager(attLayoutManager);
        presenter.attach(this);
    }



    public void bind(Post post, List<User> users, List<Group> groups){

        userLike = post.getLikes().getUserLikes();
        postId = post.getPostId();
        ownerId = post.getSourceId();

        if(post.getSourceId() < -1) {
            for (int i = 0; i <= groups.size(); i++) {
                if (groups.get(i).getId() == Math.abs(post.getSourceId())) {
                    postTitle.setText(groups.get(i).getName());
                    Glide.with(itemView.getContext()).load(groups.get(i).getPhoto50()).into(postAvatar);
                    break;
                }
            }
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == post.getSourceId()) {
                    postTitle.setText(users.get(i).getDisplayName());
                    Glide.with(itemView.getContext()).load(users.get(i).getPhoto50()).into(postAvatar);
                    break;
                }
            }
        }

        if(post.getAttachments() != null) {
            attRecyclerView.setAdapter(new AttachmentsAdapter(itemView.getContext(), post.getAttachments()));
        }

        postDescription.setText(post.getText());

        if (post.getPostType().equals("post")) {
            likeCount.setText(String.valueOf(post.getLikes().getCount()));
            commentCount.setText(String.valueOf(post.getComments().getCount()));
            repostCount.setText(String.valueOf(post.getReposts().getCount()));
            viewCount.setText(String.valueOf(post.getViews().getCount()));
        }

        if(userLike == 1) {
            likeIcon.setImageResource(R.drawable.ic_liked_24dp);
        }

        postDate.setText(new java.text.SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH).
                format(new java.util.Date((post.getDate() + 10800) * 1000)));

        //set Repost View
        if (post.getCopyHistory() != null) {

            repostAvatar.setVisibility(View.VISIBLE);
            repostDate.setVisibility(View.VISIBLE);
            repostDescription.setVisibility(View.VISIBLE);
            repostTitle.setVisibility(View.VISIBLE);

            if(post.getCopyHistory().get(0).getOwnerId() < -1) {
                for (int i = 0; i <= groups.size(); i++) {
                    if (groups.get(i).getId() == Math.abs(post.getCopyHistory().get(0).getOwnerId())) {
                        repostTitle.setText(groups.get(i).getName());
                        Glide.with(itemView.getContext()).load(groups.get(i).getPhoto50()).into(repostAvatar);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getId() == post.getCopyHistory().get(0).getOwnerId()) {
                        repostTitle.setText(users.get(i).getDisplayName());
                        Glide.with(itemView.getContext()).load(users.get(i).getPhoto50()).into(repostAvatar);
                        break;
                    }
                }
            }

            repostDescription.setText(post.getCopyHistory().get(0).getText());

            repostDate.setText(new java.text.SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH).
                    format(new java.util.Date((post.getCopyHistory().get(0).getDate() + 10800) * 1000)));

            if(post.getCopyHistory().get(0).getAttachments() != null) {
                attRecyclerView.setAdapter(new AttachmentsAdapter(itemView.getContext(), post.getCopyHistory().get(0).getAttachments()));
            }
        }

    }

    @OnClick(R.id.like_icon) void onLikeClick() {
        if(userLike == 0) {
            userLike = 1;
            presenter.addLike(ownerId, postId, itemView.getContext());
        } else {
            userLike = 0;
            presenter.addDislike(ownerId, postId, itemView.getContext());
        }
    }

    @Override
    public void setLike(LikeResponse likeResponse) {
        likeIcon.setImageResource(R.drawable.ic_liked_24dp);
        likeCount.setText(String.valueOf(likeResponse.getLikes().getLikesCount()));
    }

    @Override
    public void setDislike(LikeResponse likeResponse) {
        likeIcon.setImageResource(R.drawable.ic_nolike_24dp);
        likeCount.setText(String.valueOf(likeResponse.getLikes().getLikesCount()));
    }
}
