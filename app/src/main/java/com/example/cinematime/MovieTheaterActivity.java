package com.example.cinematime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTheaterActivity extends AppCompatActivity {
    private ListView movieTheaterListView;

    Map<String, String> movieTheaterMap = new HashMap<String, String>() { {
        put("Cinematec Tel-Aviv", "https://www.cinema.co.il/");
        put("Cinema City Rishon Lezzion", "https://www.cinema-city.co.il/location/2");
        put("Yes Planet Rishon Lezzion", "https://www.planetcinema.co.il/cinemas/Rishon_Letziyon/1072#/buy-tickets-by-cinema?in-cinema=1072&at=2023-03-25&view-mode=list");
        put("Yes Planet Beer-Sheva", "https://www.planetcinema.co.il/cinemas/beersheva/1074#/buy-tickets-by-cinema?in-cinema=1074&at=2023-03-25&view-mode=list");
        put("Cinema city Glilot", "https://www.cinema-city.co.il/location/1");
    }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_theater);

        movieTheaterListView = findViewById(R.id.movieTheaterListView);

        List<String> movieTheaterNames = new ArrayList<>(movieTheaterMap.keySet());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, movieTheaterNames);
        movieTheaterListView.setAdapter(arrayAdapter);

        movieTheaterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = movieTheaterMap.get(movieTheaterNames.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}