package com.example.news.models;

import android.widget.VideoView;

import java.io.Serializable;

public class ModelVideoSourceList implements Serializable {
    private String name, description;
    private VideoView videolUrl;

    private ModelVideoSourceList(){}

    // constructor
    public ModelVideoSourceList(String name, String description,VideoView videoUrl) {


        this.name = name;
        this.description = description;
        this.videolUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VideoView getVideolUrl() {
        return videolUrl;
    }

    public void setVideolUrl(VideoView videolUrl) {
        this.videolUrl = videolUrl;
    }

    public class NewsDetail {
        private String content;
    }
}