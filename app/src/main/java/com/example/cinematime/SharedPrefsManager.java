package com.example.cinematime;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class SharedPrefsManager {
    public static final String SHARED_PREFS_FAVOURITES_KEY = "PREFS_FAVOURITES_KEY_";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
    }

    public static boolean isInFavourites(Movie movie, Context context) {
        return getSharedPreferences(context)
                .getBoolean(getMovieFavouritesKey(movie), false);
    }

    public static void removeFromFavourites(Movie movie, Context context) {
        getSharedPreferences(context).edit().remove(getMovieFavouritesKey(movie)).apply();
    }

    public static void addToFavourites(Movie movie, Context context) {
        getSharedPreferences(context).edit().putBoolean(getMovieFavouritesKey(movie), true).apply();
    }

    public static List<Movie> getFavouriteMovieList(List<Movie> movieList, Context context) {
        List<Movie> favouriteMovieList = new ArrayList<>();

        for(Movie movie : movieList) {
            if(isInFavourites(movie, context)) {
                favouriteMovieList.add(movie);
            }
        }

        return favouriteMovieList;
    }

    public static String getMovieFavouritesKey(Movie movie) {
        return SHARED_PREFS_FAVOURITES_KEY + movie.getId();
    }
}
