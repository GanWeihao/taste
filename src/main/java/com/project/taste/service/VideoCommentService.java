package com.project.taste.service;

import com.project.taste.model.VideoComment;

public interface VideoCommentService {
    int deleteByPrimaryKey(String videoCommentId);

    int insert(VideoComment record);

    int insertSelective(VideoComment record);

    VideoComment selectByPrimaryKey(String videoCommentId);

    int updateByPrimaryKeySelective(VideoComment record);

    int updateByPrimaryKey(VideoComment record);
}