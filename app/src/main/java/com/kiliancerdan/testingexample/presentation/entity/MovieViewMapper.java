package com.kiliancerdan.testingexample.presentation.entity;

import com.kiliancerdan.testingexample.entity.movie.Movie;
import com.kiliancerdan.testingexample.presentation.entity.movie.MovieView;

import java.util.ArrayList;
import java.util.List;

public class MovieViewMapper {

    public static List<MovieView> convertMovieToView(List<Movie> movies) {
        List<MovieView> moviesView = new ArrayList<>();
        for (Movie movie : movies) {
            moviesView.add(convertMovieToView(movie));
        }
        return moviesView;
    }

    public static MovieView convertMovieToView(Movie movie) {
        return new MovieView(movie.getId(),
                movie.getTitle(),
                movie.getOverview(),
                movie.getPosterUrl());
    }
}
