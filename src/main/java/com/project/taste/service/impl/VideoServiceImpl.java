package com.project.taste.service.impl;

import com.project.taste.mapper.VideoMapper;
import com.project.taste.model.Video;
import com.project.taste.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

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

    /**
     * 查询所有视频
     * @return
     */
    @Override
    public List<Video> queryVideoAll() {
        List<Video> list=videoMapper.queryVideoAll();
        return list;
    }

    /**
     * 根据用户ID查询该用户上传的视频数量
     * @param userId
     * @return
     */
    @Override
    public int queryVideoNum(String userId) {
        int num=videoMapper.queryVideoNum(userId);
        return num;
    }

    /**
     * 根据视频ID查询视频详情
     * @param videoId
     * @return
     */
    @Override
    public Video queryVideoById(String videoId) {
        Video video=videoMapper.queryVideoById(videoId);
        return video;
    }
}