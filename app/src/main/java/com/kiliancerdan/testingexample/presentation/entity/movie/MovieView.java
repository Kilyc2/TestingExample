package com.kiliancerdan.testingexample.presentation.entity.movie;

public class MovieView {

    private final int id;
    private final String title;
    private final String overview;
    private final String posterUrl;

    public MovieView(int id, String title, String overview, String posterUrl) {
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