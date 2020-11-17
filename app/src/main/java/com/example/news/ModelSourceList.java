package com.example.news;

public class ModelSourceList {

    private String name, description, category;

    private  ModelSourceList(){}

    private ModelSourceList(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // getters and setters
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
}