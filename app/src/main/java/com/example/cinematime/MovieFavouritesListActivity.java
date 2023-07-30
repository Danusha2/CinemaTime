package com.example.cinematime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieFavouritesListActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;
    GoogleSignInAccount account;
    List<Integer> indexList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_favourites_list);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            account = (GoogleSignInAccount)extras.get("user");
        }
        movieRecyclerView = findViewById(R.id.movieRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("FavouritesMovies")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            try {
                                indexList.add(Integer.parseInt(Objects.requireNonNull(document.get("movieID")).toString()));

                            } catch (Exception e) {
                            }
                        }
                    }
                });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);
        System.out.println("movieFavouritesListActivity" + indexList);
        List<Movie> favouriteMovieList = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            favouriteMovieList.add(MovieManager.movieList.get(indexList.get(i)-1));
        }

        MovieAdapter movieAdapter = new MovieAdapter(favouriteMovieList,
                R.layout.movie_favourites_list_item,
                this);
        movieRecyclerView.setAdapter(movieAdapter);
    }
}