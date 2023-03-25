package com.example.cinematime;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movieList;
    private Activity activity;
    private int listItemLayoutId;

    public MovieAdapter(List<Movie> movieList, int listItemLayoutId, Activity activity) {
            this.movieList = movieList;
            this.listItemLayoutId = listItemLayoutId;
            this.activity = activity;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayoutId,parent,false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.movieTitleTextView.setText(movie.getTitle());
        holder.movieImageView.setImageResource(movie.getImageId());
        holder.movieCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, MovieActivity.class);
                intent.putExtra(MovieActivity.MOVIE_EXTRA, movie);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return movieList.size(); }
}
