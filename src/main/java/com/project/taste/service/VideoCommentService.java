package com.project.taste.service;

import com.project.taste.model.VideoComment;

import java.util.List;

public interface VideoCommentService {
    int deleteByPrimaryKey(String videoCommentId);

    int insert(VideoComment record);

    int insertSelective(VideoComment record);

    VideoComment selectByPrimaryKey(String videoCommentId);

    int updateByPrimaryKeySelective(VideoComment record);

    int updateByPrimaryKey(VideoComment record);

    //根据视频ID查询视频的所有评论
    List<VideoComment> queryVideoCommentByVideoId(String videoId);

    //查询所有视频评论
    List<VideoComment> queryVideoCommentAll();

    //查询视频评论数量
    int queryVideoCommentNum();
    //根据用户ID查询所有评论
    List<VideoComment> queryVideoCommentByUserId(String userId);
}