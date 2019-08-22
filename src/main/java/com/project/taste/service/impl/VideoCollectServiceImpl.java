package com.project.taste.service.impl;

import com.project.taste.mapper.VideoCollectMapper;
import com.project.taste.model.Video;
import com.project.taste.model.VideoCollect;
import com.project.taste.service.VideoCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoCollectServiceImpl implements VideoCollectService {
    @Autowired
    VideoCollectMapper videoCollectMapper;

    @Override
    public int deleteByPrimaryKey(String videoCollectId) {
        return 0;
    }

    @Override
    public int insert(VideoCollect record) {
        return 0;
    }

    @Override
    public int insertSelective(VideoCollect record) {
        return 0;
    }

    @Override
    public VideoCollect selectByPrimaryKey(String videoCollectId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(VideoCollect record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(VideoCollect record) {
        return 0;
    }
    /**
     * 添加视频收藏
     */
    @Override
    public int insertVideoCollect(VideoCollect record){
        VideoCollect video=new VideoCollect();
        String id = UUID.randomUUID().toString().replaceAll("-","");
        video.setVideoCollectId(id);
        video.setVideoCollectTime(new Date());
        video.setVideoCollectUserId(record.getVideoCollectUserId());
        video.setVideoCollectVideoId(record.getVideoCollectVideoId());
        return videoCollectMapper.insertVideoCollect(video);
    }
    /**
     * 根据用户id查询所有收藏视频
     */
    @Override
    public List<Video> selectVideoByUId(String videoCollectUserId){
        return videoCollectMapper.selectVideoByUId(videoCollectUserId);
    }
    /**
     * 根据视频ID查收藏数量
     */
    @Override
    public int selectVideoCount(String videoCollectVideoId){
        return videoCollectMapper.selectVideoCount(videoCollectVideoId);
    }
    /**
     * 删除视频收藏
     */
    @Override
    public int deleteVideoCollect(String videoCollectVideoId,String videoCollectUserId){
        return  videoCollectMapper.deleteVideoCollect(videoCollectVideoId,videoCollectUserId);
    }
}