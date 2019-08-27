package com.project.taste.bo;

import com.project.taste.model.User;

import java.util.Date;

public class VideoComment_User {
    private String videoCommentId;

    private String videoCommentContent;

    private Date videoCommentTime;

    private String videoCommentUserId;

    private String videoCommentVideoId;

    private String videoCommentTouserId;

    private Integer videoCommentStatus;

    private User user;

    private User toUser;

    public VideoComment_User(String videoCommentId, String videoCommentContent, Date videoCommentTime, String videoCommentUserId, String videoCommentVideoId, String videoCommentTouserId, Integer videoCommentStatus, User user, User toUser) {
        this.videoCommentId = videoCommentId;
        this.videoCommentContent = videoCommentContent;
        this.videoCommentTime = videoCommentTime;
        this.videoCommentUserId = videoCommentUserId;
        this.videoCommentVideoId = videoCommentVideoId;
        this.videoCommentTouserId = videoCommentTouserId;
        this.videoCommentStatus = videoCommentStatus;
        this.user = user;
        this.toUser = toUser;
    }

    public VideoComment_User() {
        super();
    }

    public String getVideoCommentId() {
        return videoCommentId;
    }

    public void setVideoCommentId(String videoCommentId) {
        this.videoCommentId = videoCommentId;
    }

    public String getVideoCommentContent() {
        return videoCommentContent;
    }

    public void setVideoCommentContent(String videoCommentContent) {
        this.videoCommentContent = videoCommentContent;
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
        this.videoCommentUserId = videoCommentUserId;
    }

    public String getVideoCommentVideoId() {
        return videoCommentVideoId;
    }

    public void setVideoCommentVideoId(String videoCommentVideoId) {
        this.videoCommentVideoId = videoCommentVideoId;
    }

    public String getVideoCommentTouserId() {
        return videoCommentTouserId;
    }

    public void setVideoCommentTouserId(String videoCommentTouserId) {
        this.videoCommentTouserId = videoCommentTouserId;
    }

    public Integer getVideoCommentStatus() {
        return videoCommentStatus;
    }

    public void setVideoCommentStatus(Integer videoCommentStatus) {
        this.videoCommentStatus = videoCommentStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
}
