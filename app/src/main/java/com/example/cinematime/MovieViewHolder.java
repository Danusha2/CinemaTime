package com.example.cinematime;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public CardView movieCardView;
    public ImageView movieImageView;
    public TextView movieTitleTextView;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieCardView = itemView.findViewById(R.id.movieCardView);
        movieImageView = itemView.findViewById(R.id.movieImageView);
        movieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
    }
}
