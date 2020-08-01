package com.example.mvpproject.Root;

import com.example.mvpproject.Details.NewsDetailActivity;
import com.example.mvpproject.Details.NewsDetailModule;
import com.example.mvpproject.Http.NewsApiModule;
import com.example.mvpproject.NewsList.NewListActivity;
import com.example.mvpproject.NewsList.NewsListModule;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules =
        {ApplicationModule.class, NewsApiModule.class, NewsListModule.class,NewsDetailModule.class})
public interface ApplicationComponent {

    void inject(NewListActivity target);

    void inject(NewsDetailActivity newsDetailActivity);
}