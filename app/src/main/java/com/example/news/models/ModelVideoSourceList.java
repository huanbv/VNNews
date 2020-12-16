package com.example.news.models;

import java.io.Serializable;

public class ModelVideoSourceList implements Serializable {
    private String name, description;
    private String videoUrl;

    private ModelVideoSourceList(){}

    // constructor
    public ModelVideoSourceList(String name, String description, String videoUrl) {
        this.name = name;
        this.description = description;
        this.videoUrl = videoUrl;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public class NewsDetail {
        private String content;
    }
}