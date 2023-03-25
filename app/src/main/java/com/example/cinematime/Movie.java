package com.example.cinematime;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String summary;
    private int releaseYear;
    private List<String> actorNameList;
    private int imageId;
    private int videoId;


    public Movie(int id, String title, String summary, int releaseYear,
                 List<String> actorNameList, int imageId, int videoId) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.releaseYear = releaseYear;
        this.actorNameList = actorNameList;
        this.imageId = imageId;
        this.videoId = videoId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<String> getActorNameList() {
        return actorNameList;
    }

    public int getImageId() {
        return imageId;
    }

    public int getVideoId() {
        return videoId;
    }
}
