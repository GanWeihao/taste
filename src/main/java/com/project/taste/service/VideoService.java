package com.project.taste.service;

import com.project.taste.model.Video;

import java.util.List;

public interface VideoService {
    int deleteByPrimaryKey(String videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(String videoId);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    //查询所有视频
    List<Video> queryVideoAll();
}