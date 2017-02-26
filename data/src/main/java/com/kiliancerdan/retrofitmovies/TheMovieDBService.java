package com.kiliancerdan.retrofitmovies;


import com.kiliancerdan.retrofitmovies.response.movie.MovieResponse;
import com.kiliancerdan.retrofitmovies.response.movie.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheMovieDBService {

    @GET("{id}")
    Call<MovieResponse> getMovie(@Path("id") String idMovie);

    @GET("popular")
    Call<MoviesResponse> getPopularMovies();

    @GET("top_rated")
    Call<MoviesResponse> getTopMovies();

}
