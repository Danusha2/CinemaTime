package com.example.cinematime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MovieFavouritesListActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_favourites_list);
        movieRecyclerView = findViewById(R.id.movieRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);

        List<Movie> favouriteMovieList
                = SharedPrefsManager.getFavouriteMovieList(MovieManager.movieList, this);

        MovieAdapter movieAdapter = new MovieAdapter(favouriteMovieList,
                R.layout.movie_favourites_list_item,
                this);
        movieRecyclerView.setAdapter(movieAdapter);
    }
}