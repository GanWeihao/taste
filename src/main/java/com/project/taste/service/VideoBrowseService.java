package com.project.taste.service;

import com.project.taste.model.VideoBrowse;

import java.util.List;

public interface VideoBrowseService {
    //删除视频浏览记录
    int deleteByPrimaryKey(String videoBrowseId);
    //添加视频浏览记录
    int insert(String videoBroweUserId,String VideoBroweVideoId);

    int insertSelective(VideoBrowse record);

    VideoBrowse selectByPrimaryKey(String videoBrowseId);

    int updateByPrimaryKeySelective(VideoBrowse record);

    int updateByPrimaryKey(VideoBrowse record);
    //根据用户ID查询用户浏览视频记录
    List<VideoBrowse> queryVideoBrowseByUserId(String userId);
    //根据用户ID查询用户浏览视频数量
    int queryVideoBrowseNum(String userId);
}