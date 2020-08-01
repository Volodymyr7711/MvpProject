package com.example.mvpproject.Details;

import com.example.mvpproject.Http.Model.Article;

public interface NewsDetailPresenter {
    void showDetails(Article article);

    void setView(NewsDetailsView view);

    void destroy();
}
