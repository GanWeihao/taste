package com.project.taste.service.impl;

import com.project.taste.mapper.VideoBrowseMapper;
import com.project.taste.model.VideoBrowse;
import com.project.taste.service.VideoBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoBrowseServiceImpl implements VideoBrowseService {
    @Autowired
    VideoBrowseMapper videoBrowseMapper;

    @Override
    public int deleteByPrimaryKey(String videoBrowseId) {
        return 0;
    }

    @Override
    public int insert(VideoBrowse record) {
        return 0;
    }

    @Override
    public int insertSelective(VideoBrowse record) {
        return 0;
    }

    @Override
    public VideoBrowse selectByPrimaryKey(String videoBrowseId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(VideoBrowse record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(VideoBrowse record) {
        return 0;
    }

    /**
     * 根据用户ID查询用户浏览视频记录
     * @param userId
     * @return
     */
    @Override
    public List<VideoBrowse> queryVideoBrowseByUserId(String userId) {
        List<VideoBrowse> list=videoBrowseMapper.queryVideoBrowseByUserId(userId);
        return list;
    }
    //根据用户ID查询用户浏览视频数量
    @Override
    public int queryVideoBrowseNum(String userId) {
        int num=videoBrowseMapper.queryVideoBrowseNum(userId);
        return num;
    }
}