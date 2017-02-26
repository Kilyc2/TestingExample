package com.kiliancerdan.testingexample.presentation;

import com.kiliancerdan.testingexample.MoviesInteractor;
import com.kiliancerdan.testingexample.entity.movie.Movie;
import com.kiliancerdan.testingexample.presentation.entity.MovieViewMapper;
import com.kiliancerdan.testingexample.presentation.entity.movie.MovieView;

import java.util.List;

class MainPresenter implements MoviesInteractor.MovieCallback {

    private MainView view;
    private MoviesInteractor moviesInteractor;

    public MainPresenter(MainView view) {
        this.view = view;
        moviesInteractor = new MoviesInteractor(this);
    }

    void getPopularMoview() {
        moviesInteractor.getPopularMovies();
    }

    void getTopMovies() {
        moviesInteractor.getTopMovies();
    }

    @Override
    public void providesMovies(List<Movie> movies) {
        List<MovieView> moviesView = MovieViewMapper.convertMovieToView(movies);
        view.showMovies(moviesView);
    }

    @Override
    public void providesMoviesFailure() {
        view.showError();
    }

    interface MainView {
        void showMovies(List<MovieView> movies);
        void showError();
    }
}
