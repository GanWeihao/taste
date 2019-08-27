package com.project.taste.bo;

import com.project.taste.model.Video;

import java.util.Date;

public class VideoBrowse_Video {
    private String videoBrowseId;

    private String videoBrowseVideoId;

    private String videoBrowseUserId;

    private Date videoBrowseTime;

    private Video video;

    public VideoBrowse_Video(String videoBrowseId, String videoBrowseVideoId, String videoBrowseUserId, Date videoBrowseTime, Video video) {
        this.videoBrowseId = videoBrowseId;
        this.videoBrowseVideoId = videoBrowseVideoId;
        this.videoBrowseUserId = videoBrowseUserId;
        this.videoBrowseTime = videoBrowseTime;
        this.video = video;
    }

    public VideoBrowse_Video() {
        super();
    }

    public String getVideoBrowseId() {
        return videoBrowseId;
    }

    public void setVideoBrowseId(String videoBrowseId) {
        this.videoBrowseId = videoBrowseId;
    }

    public String getVideoBrowseVideoId() {
        return videoBrowseVideoId;
    }

    public void setVideoBrowseVideoId(String videoBrowseVideoId) {
        this.videoBrowseVideoId = videoBrowseVideoId;
    }

    public String getVideoBrowseUserId() {
        return videoBrowseUserId;
    }

    public void setVideoBrowseUserId(String videoBrowseUserId) {
        this.videoBrowseUserId = videoBrowseUserId;
    }

    public Date getVideoBrowseTime() {
        return videoBrowseTime;
    }

    public void setVideoBrowseTime(Date videoBrowseTime) {
        this.videoBrowseTime = videoBrowseTime;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
