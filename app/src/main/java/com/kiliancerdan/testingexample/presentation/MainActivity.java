package com.kiliancerdan.testingexample.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kiliancerdan.testingexample.R;
import com.kiliancerdan.testingexample.presentation.entity.movie.MovieView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView, View.OnClickListener {

    private MoviesAdapter adapter;
    private MainPresenter presenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabPopularMovies = (FloatingActionButton) findViewById(R.id.fab_popular);
        FloatingActionButton fabTopMovies = (FloatingActionButton) findViewById(R.id.fab_top);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        fabPopularMovies.setOnClickListener(this);
        fabTopMovies.setOnClickListener(this);

        adapter = new MoviesAdapter();
        recyclerView.setAdapter(adapter);

        presenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View v) {
        String title = getString(R.string.app_name);
        switch (v.getId()) {
            case R.id.fab_popular:
                title = getString(R.string.popular_movies_title);
                presenter.getPopularMoview();
                break;
            case R.id.fab_top:
                title = getString(R.string.top_movies_title);
                presenter.getTopMovies();
                break;
        }
        toolbar.setTitle(title);
    }

    @Override
    public void showMovies(List<MovieView> movies) {
        adapter.setMovies(movies);
    }

    @Override
    public void showError() {

    }
}
