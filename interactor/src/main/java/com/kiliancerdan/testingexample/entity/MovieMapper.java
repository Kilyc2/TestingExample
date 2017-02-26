package com.kiliancerdan.testingexample.entity;

import com.kiliancerdan.retrofitmovies.response.movie.MovieResponse;
import com.kiliancerdan.retrofitmovies.response.movie.MoviesResponse;
import com.kiliancerdan.testingexample.entity.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static List<Movie> convertResponseToMovie(MoviesResponse response) {
        List<Movie> movies = new ArrayList<>();
        for (MovieResponse movieResponse : response.getResults()) {
            movies.add(convertResponseToMovie(movieResponse));
        }
        return movies;
    }

    public static Movie convertResponseToMovie(MovieResponse response) {
        return new Movie(response.getId(),
                response.getTitle(),
                response.getOverview(),
                response.getPosterUrl());
    }
}
