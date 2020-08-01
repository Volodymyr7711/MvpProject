package com.example.mvpproject.NewsList;

public interface NewsListPresenter {

    void loadNewsData();

    void rxJavaUnsubscribe();

    void setView(NewsListView view);
}
