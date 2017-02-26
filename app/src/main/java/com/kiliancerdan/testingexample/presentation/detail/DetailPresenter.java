package com.kiliancerdan.testingexample.presentation.detail;

import com.kiliancerdan.testingexample.MovieInteractor;
import com.kiliancerdan.testingexample.entity.MovieViewMapper;
import com.kiliancerdan.testingexample.entity.movie.Movie;
import com.kiliancerdan.testingexample.entity.movie.MovieView;

public class DetailPresenter implements MovieInteractor.MovieCallback {

    private DetailView view;
    private MovieInteractor movieInteractor;

    public DetailPresenter(DetailView view) {
        this.view = view;
        movieInteractor = new MovieInteractor(this);
    }

    public void getMovie(String idMovie) {
        movieInteractor.getMovie(idMovie);
    }

    @Override
    public void providesMovie(Movie movie) {
        MovieView movieView = MovieViewMapper.convertMovieToView(movie);
        view.setMovie(movieView);
    }

    @Override
    public void providesMovieFailure() {
        view.showError();
    }

    interface DetailView {
        void setMovie(MovieView movie);
        void showError();
    }
}
