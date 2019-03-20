package com.example.myxan.vk_mvp.news_feed;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.myxan.vk_mvp.Navigator;
import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.network.API.NewsFeedAPI;
import com.example.myxan.vk_mvp.network.news_feed_response.group.Group;
import com.example.myxan.vk_mvp.network.news_feed_response.post.Post;
import com.example.myxan.vk_mvp.network.news_feed_response.user.User;
import com.example.myxan.vk_mvp.news_feed.adapter.NewsFeedAdapter;
import com.example.myxan.vk_mvp.utils.di.Injector;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedActivity extends AppCompatActivity implements NewsFeedView{

    @Inject NewsFeedPresenter presenter;
    @Inject NewsFeedAPI apiCall;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.news_feed_swiperefresh) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    private NewsFeedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        ButterKnife.bind(this);
        Injector.inject(this);
        setSupportActionBar(mToolbar);
        setTitle("News feed");
        presenter.attach(this);
        if (!presenter.isLoggedIn()) {
            showLogin();
            return;
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(true);
        presenter.loadNewsFeed(this);

        swipeRefreshLayout.setOnRefreshListener(()-> {
                presenter.loadNewsFeed(this);
                swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news_feed, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showNewsFeed(List<Post> posts, List<User> users, List<Group> groups) {
        adapter = new NewsFeedAdapter(this, posts, users, groups);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    presenter.tryPaginate(layoutManager.findFirstVisibleItemPosition());
                }
            }
        });
    }

    @Override
    public void loadMoreItems(int newItemsCount) {
        try {
            adapter.updateLists(newItemsCount);
        } catch (Throwable e) {
            Toast.makeText(this, "can't add", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_logout) {
            presenter.onLogoutClicked();
            Navigator.showLoginActivity(this);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void showLogin(){
        Navigator.showLoginActivity(this);
    }
}
