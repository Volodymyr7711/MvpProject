package com.example.mvpproject.NewsList;

import com.example.mvpproject.Http.Model.Article;

public interface NewsListView {

    void showNews(Article article);

    void loadingFailed(String errorMessage);

    void loadingSuccess(String successMessage);

    void onArticleClicked(Article article);
}

