package com.project.taste.service.impl;

import com.project.taste.mapper.VideoCollectMapper;
import com.project.taste.mapper.VideoCommentMapper;
import com.project.taste.model.VideoComment;
import com.project.taste.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

    @Autowired
    VideoCommentMapper videoCommentMapper;

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

    @Override
    public List<VideoComment> queryVideoCommentByVideoId(String videoId) {
        List<VideoComment> list=videoCommentMapper.queryVideoCommentByVideoId(videoId);
        return list;
    }

}