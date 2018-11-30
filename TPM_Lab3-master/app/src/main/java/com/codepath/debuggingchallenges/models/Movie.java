package com.codepath.debuggingchallenges.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Movie {
    private String title;
    private String posterUrl;
    private double rating;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterUrl = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.rating = jsonObject.getDouble("vote_average");
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    //    public static List<Movie> fromJSONArray(JSONArray jsonArray) throws JSONException {
//        List<Movie> results = new ArrayList<>();
//        Log.i("smile", "logan le" );
//        for (int i = 0; i < jsonArray.length(); i++) {
//            results.add(new Movie(jsonArray.getJSONObject(i)));
//            Log.i("smile", String.valueOf(i) );
//        }
//        return results;
//    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) {
        List<Movie> movies = new ArrayList<>();
//        Log.i("smile", String.valueOf(movieJsonArray.length()));
        for (int i = 0; i < movieJsonArray.length(); i++) {
//            Log.i("smile", String.valueOf(movieJsonArray.length()));
            try {
                movies.add(new Movie(movieJsonArray.getJSONObject(i)));
            } catch (JSONException e) {
//                Log.e("smile", "My error", e);
                e.printStackTrace();
            }
        }
        return movies;
    }
}
