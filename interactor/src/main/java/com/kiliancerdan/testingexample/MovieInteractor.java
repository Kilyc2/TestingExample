package com.kiliancerdan.testingexample;

import com.kiliancerdan.retrofitmovies.RetrofitMovies;
import com.kiliancerdan.retrofitmovies.TheMovieDBService;
import com.kiliancerdan.retrofitmovies.response.movie.MovieResponse;
import com.kiliancerdan.testingexample.entity.MovieMapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieInteractor implements Callback<MovieResponse> {

    private TheMovieDBService service;

    public MovieInteractor() {
        Retrofit retrofit = RetrofitMovies.getRetrofit();
        service = retrofit.create(TheMovieDBService.class);
    }

    void getMovie(String idMovie) {
        service.getMovie(idMovie).enqueue(this);
    }

    @Override
    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        MovieMapper.convertResponseToMovie(response.body());
    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {

    }
}
