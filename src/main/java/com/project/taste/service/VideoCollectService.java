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
    //添加视频收藏
    int insertVideoCollect(VideoCollect record);
    //根据用户id查询所有收藏视频
    List<Video> selectVideoByUId(String videoCollectUserId);
    // 根据视频ID查收藏数量
    int selectVideoCount(String videoCollectVideoId);
    //删除视频收藏
    int deleteVideoCollect(String videoCollectVideoId,String videoCollectUserId);
}