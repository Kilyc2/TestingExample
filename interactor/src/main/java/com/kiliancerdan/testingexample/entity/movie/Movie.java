package com.kiliancerdan.testingexample.entity.movie;

public class Movie {

    private final int id;
    private final String title;
    private final String overview;
    private final String posterUrl;

    public Movie(int id, String title, String overview, String posterUrl) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterUrl = posterUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}