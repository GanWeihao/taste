package com.project.taste.service.impl;

import com.project.taste.model.VideoComment;
import com.project.taste.service.VideoCommentService;
import org.springframework.stereotype.Service;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

    @Override
    public int deleteByPrimaryKey(String videoCommentId) {
        return 0;
    }

    @Override
    public int insert(VideoComment record) {
        return 0;
    }

    @Override
    public int insertSelective(VideoComment record) {
        return 0;
    }

    @Override
    public VideoComment selectByPrimaryKey(String videoCommentId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(VideoComment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(VideoComment record) {
        return 0;
    }
}