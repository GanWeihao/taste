package com.project.taste.bo;

import com.project.taste.model.Video;

import java.util.Date;

public class VideoCollect_Video {
    private String videoCollectId;

    private String videoCollectVideoId;

    private String videoCollectUserId;

    private Date videoCollectTime;

    private Video video;

    public VideoCollect_Video(String videoCollectId, String videoCollectVideoId, String videoCollectUserId, Date videoCollectTime, Video video) {
        this.videoCollectId = videoCollectId;
        this.videoCollectVideoId = videoCollectVideoId;
        this.videoCollectUserId = videoCollectUserId;
        this.videoCollectTime = videoCollectTime;
        this.video = video;
    }

    public VideoCollect_Video() {
        super();
    }

    public String getVideoCollectId() {
        return videoCollectId;
    }

    public void setVideoCollectId(String videoCollectId) {
        this.videoCollectId = videoCollectId;
    }

    public String getVideoCollectVideoId() {
        return videoCollectVideoId;
    }

    public void setVideoCollectVideoId(String videoCollectVideoId) {
        this.videoCollectVideoId = videoCollectVideoId;
    }

    public String getVideoCollectUserId() {
        return videoCollectUserId;
    }

    public void setVideoCollectUserId(String videoCollectUserId) {
        this.videoCollectUserId = videoCollectUserId;
    }

    public Date getVideoCollectTime() {
        return videoCollectTime;
    }

    public void setVideoCollectTime(Date videoCollectTime) {
        this.videoCollectTime = videoCollectTime;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
