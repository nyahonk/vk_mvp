package com.example.myxan.vk_mvp.news_feed.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;

import java.util.List;


public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapterHolder> {

    private Context context;
    private List<Post> posts;
    private List<User> users;
    private List<Group> groups;


    public NewsFeedAdapter(Context context, List<Post> posts, List<User> users, List<Group> groups) {
        this.context = context;
        this.posts = posts;
        this.users = users;
        this.groups = groups;
    }

    @NonNull
    @Override
    public NewsFeedAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_feed_post_item, parent, false);
        return new NewsFeedAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedAdapterHolder holder, int position) {
        holder.setIsRecyclable(false);


        holder.bind(posts.get(position),
                users,
                groups);

    }

    public void updateLists(int newItemsCount) {
        int oldPostsSize = posts.size() - newItemsCount;
        notifyItemRangeChanged(oldPostsSize, posts.size());
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }
}
