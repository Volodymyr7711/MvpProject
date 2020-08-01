package com.example.mvpproject.NewsList;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpproject.Details.NewsDetailActivity;
import com.example.mvpproject.Http.Model.Article;
import com.example.mvpproject.R;
import com.example.mvpproject.Root.App;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewListActivity extends AppCompatActivity implements NewsListView {

    private final String TAG = NewListActivity.class.getName();

    @BindView(R.id.news_list_activity_root)
    ViewGroup rootView;

    @BindView(R.id.recycler_view_news)
    RecyclerView recyclerView;

    @Inject
    NewsListPresenter presenter;

    private ListAdapter listAdapter;
    private List<Article> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplication()).getComponent().inject(this);

        if (savedInstanceState == null) {
            listAdapter = new ListAdapter(newsList, this);

            recyclerView.setAdapter(listAdapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

    }

    @Override
    public void showNews(Article article) {
        newsList.add(article);
        listAdapter.notifyItemInserted(newsList.size() - 1);
        Log.d(TAG, "News Added: " + article.getTitle());

    }

    @Override
    public void loadingFailed(String errorMessage) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loadingSuccess(String successMessage) {
        Snackbar.make(rootView, successMessage, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onArticleClicked(Article article) {
        Log.d(TAG, "Article Clicked: " + article.getTitle());

        Intent intent = new Intent(this, NewsDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable("com.kintopp.pablo.newsandroidmvp.article", article);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadNewsData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxJavaUnsubscribe();
    }

}
