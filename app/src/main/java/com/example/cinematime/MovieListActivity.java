package com.example.cinematime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.Arrays;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;
    GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        movieRecyclerView = findViewById(R.id.movieRecyclerView);;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            account = (GoogleSignInAccount)extras.get("user");
        }

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        movieRecyclerView.setLayoutManager(layoutManager);
        MovieAdapter movieAdapter = new MovieAdapter(MovieManager.movieList,
                R.layout.movie_list_item,
                this);
        movieRecyclerView.setAdapter(movieAdapter);
    }

    public void onShowFavouritesClick(View view) {
        Intent intent = new Intent(this, MovieFavouritesListActivity.class);
        intent.putExtra("user", account);
        startActivity(intent);
    }

    public void onShowMovieTheaterClick(View view) {
        Intent intent = new Intent(this, MovieTheaterActivity.class);
        startActivity(intent);
    }
}