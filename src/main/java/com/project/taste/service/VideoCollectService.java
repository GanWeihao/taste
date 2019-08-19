package com.project.taste.service;

import com.project.taste.model.VideoCollect;

public interface VideoCollectService {
    int deleteByPrimaryKey(String videoCollectId);

    int insert(VideoCollect record);

    int insertSelective(VideoCollect record);

    VideoCollect selectByPrimaryKey(String videoCollectId);

    int updateByPrimaryKeySelective(VideoCollect record);

    int updateByPrimaryKey(VideoCollect record);
}