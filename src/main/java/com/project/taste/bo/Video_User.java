package com.project.taste.bo;

import com.project.taste.model.User;

import java.util.Date;

public class Video_User {
    private String videoId;

    private String videoUserId;

    private String videoUrl;

    private String videoTitle;

    private String videoContent;

    private Date videoTime;

    private Integer videoStatus;

    private  String videoCategoryId;

    private User user;

    public Video_User(String videoId, String videoUserId, String videoUrl, String videoTitle, String videoContent, Date videoTime, Integer videoStatus, String videoCategoryId, User user) {
        this.videoId = videoId;
        this.videoUserId = videoUserId;
        this.videoUrl = videoUrl;
        this.videoTitle = videoTitle;
        this.videoContent = videoContent;
        this.videoTime = videoTime;
        this.videoStatus = videoStatus;
        this.videoCategoryId = videoCategoryId;
        this.user = user;
    }

    public Video_User() {
        super();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(String videoUserId) {
        this.videoUserId = videoUserId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent;
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

    public String getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(String videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
