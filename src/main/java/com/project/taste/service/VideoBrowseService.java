package com.project.taste.service;

import com.project.taste.model.VideoBrowse;

import java.util.List;

public interface VideoBrowseService {
    int deleteByPrimaryKey(String videoBrowseId);

    int insert(VideoBrowse record);

    int insertSelective(VideoBrowse record);

    VideoBrowse selectByPrimaryKey(String videoBrowseId);

    int updateByPrimaryKeySelective(VideoBrowse record);

    int updateByPrimaryKey(VideoBrowse record);
    //根据用户ID查询用户浏览视频记录
    List<VideoBrowse> queryVideoBrowseByUserId(String userId);
    //根据用户ID查询用户浏览视频数量
    int queryVideoBrowseNum(String userId);
}