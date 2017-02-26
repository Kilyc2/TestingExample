package com.kiliancerdan.testingexample;

import com.kiliancerdan.retrofitmovies.RetrofitMovies;
import com.kiliancerdan.retrofitmovies.TheMovieDBService;
import com.kiliancerdan.retrofitmovies.response.movie.MovieResponse;
import com.kiliancerdan.testingexample.entity.MovieMapper;
import com.kiliancerdan.testingexample.entity.movie.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieInteractor implements Callback<MovieResponse> {

    private TheMovieDBService service;
    private MovieCallback callback;

    public MovieInteractor(MovieCallback callback) {
        Retrofit retrofit = RetrofitMovies.getRetrofit();
        service = retrofit.create(TheMovieDBService.class);
        this.callback = callback;
    }

    public void getMovie(String idMovie) {
        service.getMovie(idMovie).enqueue(this);
    }

    @Override
    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        Movie movie = MovieMapper.convertResponseToMovie(response.body());
        callback.providesMovie(movie);
    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {
        callback.providesMovieFailure();
    }

    public interface MovieCallback {
        void providesMovie(Movie movie);
        void providesMovieFailure();
    }
}
