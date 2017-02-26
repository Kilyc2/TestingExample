package com.kiliancerdan.testingexample.entity.movie;

public class MovieView {

    private final String id;
    private final String title;
    private final String overview;
    private final String posterUrl;
    private final String posterUrlDetail;

    public MovieView(String id, String title, String overview, String posterUrl) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterUrl = "http://image.tmdb.org/t/p/w500/".concat(posterUrl);
        this.posterUrlDetail = "http://image.tmdb.org/t/p/original/".concat(posterUrl);
    }

    public String getId() {
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

    public String getPosterUrlDetail() {
        return posterUrlDetail;
    }
}