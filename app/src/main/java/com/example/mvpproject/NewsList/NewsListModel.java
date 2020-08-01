package com.example.mvpproject.NewsList;

import com.example.mvpproject.Http.Model.Article;

import io.reactivex.Observable;

public interface NewsListModel {

    Observable<Article> result();
}
