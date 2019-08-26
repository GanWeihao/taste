package com.project.taste.model;

import java.util.Date;

public class VideoComment {
    private String videoCommentId;

    private String videoCommentContent;

    private Date videoCommentTime;

    private String videoCommentUserId;

    private String videoCommentVideoId;

    private String videoCommentTouserId;

    private Integer videoCommentStatus;

    User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public VideoComment(String videoCommentId, String videoCommentContent, Date videoCommentTime, String videoCommentUserId, String videoCommentVideoId, String videoCommentTouserId, Integer videoCommentStatus) {
        this.videoCommentId = videoCommentId;
        this.videoCommentContent = videoCommentContent;
        this.videoCommentTime = videoCommentTime;
        this.videoCommentUserId = videoCommentUserId;
        this.videoCommentVideoId = videoCommentVideoId;
        this.videoCommentTouserId = videoCommentTouserId;
        this.videoCommentStatus = videoCommentStatus;
    }

    public VideoComment() {
        super();
    }

    public String getVideoCommentId() {
        return videoCommentId;
    }

    public void setVideoCommentId(String videoCommentId) {
        this.videoCommentId = videoCommentId == null ? null : videoCommentId.trim();
    }

    public String getVideoCommentContent() {
        return videoCommentContent;
    }

    public void setVideoCommentContent(String videoCommentContent) {
        this.videoCommentContent = videoCommentContent == null ? null : videoCommentContent.trim();
    }

    public Date getVideoCommentTime() {
        return videoCommentTime;
    }

    public void setVideoCommentTime(Date videoCommentTime) {
        this.videoCommentTime = videoCommentTime;
    }

    public String getVideoCommentUserId() {
        return videoCommentUserId;
    }

    public void setVideoCommentUserId(String videoCommentUserId) {
        this.videoCommentUserId = videoCommentUserId == null ? null : videoCommentUserId.trim();
    }

    public String getVideoCommentVideoId() {
        return videoCommentVideoId;
    }

    public void setVideoCommentVideoId(String videoCommentVideoId) {
        this.videoCommentVideoId = videoCommentVideoId == null ? null : videoCommentVideoId.trim();
    }

    public String getVideoCommentTouserId() {
        return videoCommentTouserId;
    }

    public void setVideoCommentTouserId(String videoCommentTouserId) {
        this.videoCommentTouserId = videoCommentTouserId == null ? null : videoCommentTouserId.trim();
    }

    public Integer getVideoCommentStatus() {
        return videoCommentStatus;
    }

    public void setVideoCommentStatus(Integer videoCommentStatus) {
        this.videoCommentStatus = videoCommentStatus;
    }
}