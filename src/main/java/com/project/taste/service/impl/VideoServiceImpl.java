package com.project.taste.service.impl;

import com.project.taste.mapper.VideoMapper;
import com.project.taste.model.Video;
import com.project.taste.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    //根据类别ID查视频
    @Override
    public List<Video> selectAllByCategoryId(String videoCategoryId) {
        return videoMapper.selectAllByCategoryId(videoCategoryId);
    }

    @Override
    public int deleteByPrimaryKey(String videoId) {
        return 0;
    }
    //添加视频
    @Override
    public int insertSelective(Video record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setVideoId(id);
        record.setVideoStatus(0);
        record.setVideoTime(new Date());
        return videoMapper.insertSelective(record);
    }

    @Override
    public int insert(Video record) {
        return 0;
    }
    //根据视频标题查询视频
    @Override
    public Video selectByPrimaryKey(String videoTitle) {
        return videoMapper.selectByPrimaryKey(videoTitle);
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return 0;
    }
    //删除视频
    @Override
    public int updateByPrimaryKey(String videoId) {
        return  videoMapper.updateByPrimaryKey(videoId);
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

    /**
     * 根据用户id查询用户上传所有视频
     * @param userId
     * @return
     */
    @Override
    public List<Video> queryVideoAllByid(String userId) {
        List<Video> list=videoMapper.queryVideoAllByid(userId);
        return list;
    }
}