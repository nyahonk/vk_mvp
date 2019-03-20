package com.example.myxan.vk_mvp.login;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.myxan.vk_mvp.Navigator;
import com.example.myxan.vk_mvp.R;
import com.example.myxan.vk_mvp.auth.AuthScopes;
import com.example.myxan.vk_mvp.utils.di.Injector;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Inject
    protected LoginPresenter presenter;

    private static final int SCOPES = AuthScopes.FRIENDS
            + AuthScopes.OFFLINE
            + AuthScopes.WALL;

    private static final String LOGIN_URL = "https://oauth.vk.com/authorize" +
            "?client_id=" + 6743235 +
            "&redirect_uri=" + "https://oauth.vk.com/blank.html" +
            "&display=" + "mobile" +
            "&scope=" + SCOPES +
            "&response_type=" + "token" +
            "&v=" + 5.87;

    @BindView(R.id.login_auth_web_view)WebView uiLogin;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        setTitle("Login");
        Injector.inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter.attach(this);


        uiLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                if (presenter.isLoggedIn(request)) {
                    return false;
                }
                view.loadUrl(request);
                return false;
            }
        });
        uiLogin.loadUrl(LOGIN_URL);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void showNewsFeed(){
        clearWebViewCache();
        Navigator.showNewsFeed(this);
        finish();
    }

    private void clearWebViewCache() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }
}
