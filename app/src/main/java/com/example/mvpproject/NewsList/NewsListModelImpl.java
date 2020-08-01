package com.example.mvpproject.NewsList;

import com.example.mvpproject.Http.Model.Article;

import io.reactivex.Observable;

public class NewsListModelImpl implements NewsListModel {

    private NewsListRepo repo;

    public NewsListModelImpl(NewsListRepo repo) {
        this.repo = repo;
    }



    @Override
    public Observable<Article> result() {
        return repo.getArticleData();
    }
}