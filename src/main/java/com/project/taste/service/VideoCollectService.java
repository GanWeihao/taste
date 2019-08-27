package com.project.taste.service;

import com.project.taste.model.Video;
import com.project.taste.model.VideoCollect;

import java.util.List;

public interface VideoCollectService {
    int deleteByPrimaryKey(String videoCollectId);

    int insert(VideoCollect record);

    int insertSelective(VideoCollect record);

    VideoCollect selectByPrimaryKey(String videoCollectId);

    int updateByPrimaryKeySelective(VideoCollect record);

    int updateByPrimaryKey(VideoCollect record);
    //根据用户ID查视频收藏
    List<VideoCollect> selectByUserId(String videoCollectUserId);
    //添加视频收藏
    int insertVideoCollect(VideoCollect record);
    // 根据视频ID查收藏数量
    int selectVideoCount(String videoCollectVideoId);
    //删除视频收藏
    int deleteVideoCollect(String videoCollectId);

}