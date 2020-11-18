package com.example.news.models;

public class ModelSourceList {
    private String name, description, category, thumbnailUrl;
    private NewsDetail detail;

    private  ModelSourceList(){}

    // constructor
    public ModelSourceList(String name, String description, String category, String thumbnailUrl, NewsDetail detail) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.thumbnailUrl = thumbnailUrl;
        this.detail = detail;
    }


    public NewsDetail getDetail() {
        return detail;
    }

    public void setDetail(NewsDetail detail) {
        this.detail = detail;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public class NewsDetail {
        private String content;
    }
}