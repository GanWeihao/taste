package com.project.taste.model;

import java.util.Date;

public class VideoBrowse {
    private String videoBrowseId;

    private String videoBrowseVideoId;

    private String videoBrowseUserId;

    private Date videoBrowseTime;

    public VideoBrowse(String videoBrowseId, String videoBrowseVideoId, String videoBrowseUserId, Date videoBrowseTime) {
        this.videoBrowseId = videoBrowseId;
        this.videoBrowseVideoId = videoBrowseVideoId;
        this.videoBrowseUserId = videoBrowseUserId;
        this.videoBrowseTime = videoBrowseTime;
    }

    public VideoBrowse() {
        super();
    }

    public String getVideoBrowseId() {
        return videoBrowseId;
    }

    public void setVideoBrowseId(String videoBrowseId) {
        this.videoBrowseId = videoBrowseId == null ? null : videoBrowseId.trim();
    }

    public String getVideoBrowseVideoId() {
        return videoBrowseVideoId;
    }

    public void setVideoBrowseVideoId(String videoBrowseVideoId) {
        this.videoBrowseVideoId = videoBrowseVideoId == null ? null : videoBrowseVideoId.trim();
    }

    public String getVideoBrowseUserId() {
        return videoBrowseUserId;
    }

    public void setVideoBrowseUserId(String videoBrowseUserId) {
        this.videoBrowseUserId = videoBrowseUserId == null ? null : videoBrowseUserId.trim();
    }

    public Date getVideoBrowseTime() {
        return videoBrowseTime;
    }

    public void setVideoBrowseTime(Date videoBrowseTime) {
        this.videoBrowseTime = videoBrowseTime;
    }
}