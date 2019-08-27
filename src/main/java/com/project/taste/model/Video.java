package com.project.taste.model;

import java.util.Date;

public class Video {
    private String videoId;

    private String videoUserId;

    private String videoUrl;

    private String videoTitle;

    private String videoContent;

    private Date videoTime;

    private Integer videoStatus;

    private  String videoCategoryId;

    public String getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(String videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public Video(String videoId, String videoUserId, String videoUrl, String videoTitle, String videoContent, Date videoTime, Integer videoStatus, String videoCategoryId) {
        this.videoId = videoId;
        this.videoUserId = videoUserId;
        this.videoUrl = videoUrl;
        this.videoTitle = videoTitle;
        this.videoContent = videoContent;
        this.videoTime = videoTime;
        this.videoStatus = videoStatus;
        this.videoCategoryId=videoCategoryId;
    }

    public Video() {
        super();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(String videoUserId) {
        this.videoUserId = videoUserId == null ? null : videoUserId.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent == null ? null : videoContent.trim();
    }

    public Date getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

}