package com.project.taste.service;

import com.project.taste.model.VideoComment;

import java.util.List;

public interface VideoCommentService {

    //    int deleteByPrimaryKey(String videoCommentId,String videoCommentUserId);

    int insert(String videoCommentUserId,String videoCommentVideoId,String videoCommentContent);
    //添加视频评论
    int insertSelective(VideoComment record);

    VideoComment selectByPrimaryKey(String videoCommentId);

    int updateByPrimaryKeySelective(VideoComment record);
    //删除视频评论
    int updateByPrimaryKey(String videoCommentId);

    //根据视频ID查询视频的所有评论
    List<VideoComment> queryVideoCommentByVideoId(String videoId);

    //查询所有视频评论
    List<VideoComment> queryVideoCommentAll();

    //查询视频评论数量
    int queryVideoCommentNum(String videoCommentVideoId);
    //根据用户ID查询所有评论
    List<VideoComment> queryVideoCommentByUserId(String userId);
}