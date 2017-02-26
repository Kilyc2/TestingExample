package com.kiliancerdan.testingexample;

import com.kiliancerdan.retrofitmovies.RetrofitMovies;
import com.kiliancerdan.retrofitmovies.TheMovieDBService;
import com.kiliancerdan.retrofitmovies.response.movie.MoviesResponse;
import com.kiliancerdan.testingexample.entity.MovieMapper;
import com.kiliancerdan.testingexample.entity.movie.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MoviesInteractor implements Callback<MoviesResponse> {

    private TheMovieDBService service;
    private MoviesCallback callback;

    public MoviesInteractor(MoviesCallback callback) {
        Retrofit retrofit = RetrofitMovies.getRetrofit();
        service = retrofit.create(TheMovieDBService.class);
        this.callback = callback;
    }

    public void getPopularMovies() {
        service.getPopularMovies().enqueue(this);
    }

    public void getTopMovies() {
        service.getTopMovies().enqueue(this);
    }

    @Override
    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
        List<Movie> movies = MovieMapper.convertResponseToMovie(response.body());
        callback.providesMovies(movies);
    }

    @Override
    public void onFailure(Call<MoviesResponse> call, Throwable t) {
        callback.providesMoviesFailure();
    }

    public interface MoviesCallback {
        void providesMovies(List<Movie> movies);
        void providesMoviesFailure();
    }
}
