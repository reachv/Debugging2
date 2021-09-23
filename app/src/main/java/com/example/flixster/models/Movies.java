package com.example.flixster.models;

import android.graphics.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movies {
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    int movieId;
    double rating;

    public Movies(){

    }
    public Movies(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movies> fromJsonArray(JSONArray moviesJsonArray) throws JSONException {
        List<Movies> movies = new ArrayList<>();
        for(int i = 0; i < moviesJsonArray.length(); i++){
            movies.add(new Movies(moviesJsonArray.getJSONObject(i)));
        }
        return movies;

    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public String getBackdropPath(){
        return String. format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }


    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
