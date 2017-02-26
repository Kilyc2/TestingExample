package com.kiliancerdan.testingexample.presentation.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiliancerdan.testingexample.R;
import com.kiliancerdan.testingexample.entity.movie.MovieView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements DetailPresenter.DetailView {

    public static final String MOVIE_ID = "movieId";

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView movieTitle;
    private TextView movieDescription;
    private ImageView movieImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        String idMovie = extras.getString(MOVIE_ID);
        toolbar = (Toolbar)findViewById(R.id.detail_toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        movieTitle = (TextView) findViewById(R.id.title);
        movieDescription = (TextView) findViewById(R.id.description);
        movieImage = (ImageView) findViewById(R.id.movie_image);
        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getMovie(idMovie);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            supportFinishAfterTransition();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void setMovie(MovieView movie) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbar.setTitle(movie.getTitle());
        Picasso.with(this).load(movie.getPosterUrlDetail()).into(movieImage);
        movieTitle.setText(movie.getTitle());
        movieDescription.setText(movie.getOverview());
    }

    @Override
    public void showError() {

    }
}
