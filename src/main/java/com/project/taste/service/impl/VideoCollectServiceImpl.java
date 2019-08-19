package com.project.taste.service.impl;

import com.project.taste.model.VideoCollect;
import com.project.taste.service.VideoCollectService;
import org.springframework.stereotype.Service;

@Service
public class VideoCollectServiceImpl implements VideoCollectService {

    @Override
    public int deleteByPrimaryKey(String videoCollectId) {
        return 0;
    }

    @Override
    public int insert(VideoCollect record) {
        return 0;
    }

    @Override
    public int insertSelective(VideoCollect record) {
        return 0;
    }

    @Override
    public VideoCollect selectByPrimaryKey(String videoCollectId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(VideoCollect record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(VideoCollect record) {
        return 0;
    }
}