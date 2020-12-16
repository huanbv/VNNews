package com.example.news.models;

public class VideoItemModel {
    private String videoUrl;
    private String previewUrl;

    public VideoItemModel() {
    }

    public VideoItemModel(String videoUrl, String previewUrl) {
        this.videoUrl = videoUrl;
        this.previewUrl = previewUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}
