package com.example.cinematime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.nio.charset.StandardCharsets;

public class MovieActivity extends AppCompatActivity {
    public static String MOVIE_EXTRA = "EXTRA_MOVIE";

    private ImageView movieThumbnailImageView;
    private TextView movieTitleTextView;
    private TextView movieActorsTextView;
    private TextView movieSummaryTextView;
    private VideoView movieTrailerVideoView;
    private Button favouritesButton;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieThumbnailImageView =  findViewById(R.id.movieThumbnailImageView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);
        movieActorsTextView = findViewById(R.id.movieActorsTextView);
        movieSummaryTextView = findViewById(R.id.movieSummaryTextView);
        movieTrailerVideoView = findViewById(R.id.movieTrailerVideoView);
        favouritesButton = findViewById(R.id.favouritesButton);
        initLayout();

    }

    private void initLayout() {
        movie = getIntent().getExtras().getSerializable(MOVIE_EXTRA, Movie.class);

        movieThumbnailImageView.setImageResource(movie.getImageId());
        movieTitleTextView.setText(movie.getTitle());

        String actorsString = "";

        for(int i = 0; i < movie.getActorNameList().size(); i++) {
            if(i > 0) {
                actorsString += ", ";
            }

            actorsString += movie.getActorNameList().get(i);
        }

        movieActorsTextView.setText("Starring: " + actorsString);
        movieSummaryTextView.setText(movie.getSummary());

        movieTrailerVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                + "/" + movie.getVideoId()));
        movieTrailerVideoView.start();

        setFavouritesButtonText();
    }

    public void onFavouritesButtonClick(View view) {
        if(SharedPrefsManager.isInFavourites(movie, this)) {
            SharedPrefsManager.removeFromFavourites(movie, this);
        } else {
            SharedPrefsManager.addToFavourites(movie, this);
        }

        setFavouritesButtonText();
    }


    private void setFavouritesButtonText() {
        String buttonText;

        if(SharedPrefsManager.isInFavourites(movie, this)) {
            buttonText = "Remove from favourites";
        } else {
            buttonText = "Add to favourites";
        }

        favouritesButton.setText(buttonText);
    }
}