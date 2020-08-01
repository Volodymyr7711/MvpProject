package com.example.mvpproject.NewsList;

import com.example.mvpproject.Http.Model.Article;

import io.reactivex.Observable;

public interface NewsListRepo {

    Observable<Article> getArticleFromNetwork();
    Observable<Article> getArticleFromCache();
    Observable<Article> getArticleData();
}
