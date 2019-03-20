package com.example.myxan.vk_mvp;

import android.app.Application;
import com.example.myxan.vk_mvp.utils.di.AppComponent;
import com.example.myxan.vk_mvp.utils.di.AppModule;
import com.example.myxan.vk_mvp.utils.di.DaggerAppComponent;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerComponents();
    }

    private void initDaggerComponents() {
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
