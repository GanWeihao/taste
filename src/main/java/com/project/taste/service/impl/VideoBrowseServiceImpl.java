package com.project.taste.service.impl;

import com.project.taste.mapper.VideoBrowseMapper;
import com.project.taste.model.VideoBrowse;
import com.project.taste.service.VideoBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoBrowseServiceImpl implements VideoBrowseService {
    @Autowired
    VideoBrowseMapper videoBrowseMapper;
    //删除视频浏览记录
    @Override
    public int deleteByPrimaryKey(String videoBrowseId) {
        return videoBrowseMapper.deleteByPrimaryKey(videoBrowseId);
    }

    //添加视频浏览记录
    @Override
    public int insert(String videoBroweUserId,String VideoBroweVideoId) {
        VideoBrowse record=new VideoBrowse();
        String  id = UUID.randomUUID().toString().replaceAll("-","");
        record.setVideoBrowseId(id);
        record.setVideoBrowseTime(new Date());
        record.setVideoBrowseUserId(videoBroweUserId);
        record.setVideoBrowseVideoId(VideoBroweVideoId);
        return videoBrowseMapper.insert(record);
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