package com.project.taste.model;

import java.util.Date;

public class VideoCollect {
    private String videoCollectId;

    private String videoCollectVideoId;

    private String videoCollectUserId;

    private Date videoCollectTime;

    public VideoCollect(String videoCollectId, String videoCollectVideoId, String videoCollectUserId, Date videoCollectTime) {
        this.videoCollectId = videoCollectId;
        this.videoCollectVideoId = videoCollectVideoId;
        this.videoCollectUserId = videoCollectUserId;
        this.videoCollectTime = videoCollectTime;
    }

    public VideoCollect() {
        super();
    }

    public String getVideoCollectId() {
        return videoCollectId;
    }

    public void setVideoCollectId(String videoCollectId) {
        this.videoCollectId = videoCollectId == null ? null : videoCollectId.trim();
    }

    public String getVideoCollectVideoId() {
        return videoCollectVideoId;
    }

    public void setVideoCollectVideoId(String videoCollectVideoId) {
        this.videoCollectVideoId = videoCollectVideoId == null ? null : videoCollectVideoId.trim();
    }

    public String getVideoCollectUserId() {
        return videoCollectUserId;
    }

    public void setVideoCollectUserId(String videoCollectUserId) {
        this.videoCollectUserId = videoCollectUserId == null ? null : videoCollectUserId.trim();
    }

    public Date getVideoCollectTime() {
        return videoCollectTime;
    }

    public void setVideoCollectTime(Date videoCollectTime) {
        this.videoCollectTime = videoCollectTime;
    }
}