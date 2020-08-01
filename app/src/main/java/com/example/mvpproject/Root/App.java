package com.example.mvpproject.Root;

import android.app.Application;

import com.example.mvpproject.Details.NewsDetailModule;
import com.example.mvpproject.Http.NewsApiModule;
import com.example.mvpproject.NewsList.NewsListModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .newsApiModule(new NewsApiModule())
                .newsListModule(new NewsListModule())
                .newsDetailModule(new NewsDetailModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
