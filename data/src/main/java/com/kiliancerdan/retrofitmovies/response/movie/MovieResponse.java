package com.kiliancerdan.retrofitmovies.response.movie;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    private int id;
    private String title;
    private String overview;
    @SerializedName("poster_path")
    private String posterUrl;

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
