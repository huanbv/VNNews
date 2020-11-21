package com.example.news.models;

public class ModelNewsSourceList {
    private String name, description, category, thumbnailUrl;
    private NewsDetail detail;
    private String date;
    private String time;

    private ModelNewsSourceList(){}

    // constructor
    public ModelNewsSourceList(String name,       String description,
                               String category,   String thumbnailUrl,
                               NewsDetail detail, String date, String time) {


        this.name = name;
        this.description = description;
        this.category = category;
        this.thumbnailUrl = thumbnailUrl;
        this.detail = detail;
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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