package com.example.mvpproject.Details;


import dagger.Module;
import dagger.Provides;

@Module
public class NewsDetailModule {

    @Provides
    public NewsDetailPresenter provideNewsDetailsPresenter(){
        return new NewsDetailPresenterImpl();
    }
}
