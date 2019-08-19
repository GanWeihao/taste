package com.project.taste.service.impl;

import com.project.taste.model.Video;
import com.project.taste.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public int deleteByPrimaryKey(String videoId) {
        return 0;
    }

    @Override
    public int insert(Video record) {
        return 0;
    }

    @Override
    public int insertSelective(Video record) {
        return 0;
    }

    @Override
    public Video selectByPrimaryKey(String videoId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Video record) {
        return 0;
    }
}