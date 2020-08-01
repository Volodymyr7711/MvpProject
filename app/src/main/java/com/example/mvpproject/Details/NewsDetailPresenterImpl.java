package com.example.mvpproject.Details;

import com.example.mvpproject.Http.Model.Article;

public class NewsDetailPresenterImpl implements NewsDetailPresenter {
    private NewsDetailsView view;

    public NewsDetailPresenterImpl() {
    }

    @Override
    public void showDetails(Article article) {

        if(view != null){
            view.showDetails(article);
        }

    }

    @Override
    public void setView(NewsDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }
}
