package com.project.taste.service.impl;

import com.project.taste.mapper.VideoCollectMapper;
import com.project.taste.mapper.VideoCommentMapper;
import com.project.taste.model.VideoComment;
import com.project.taste.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

    @Autowired
    VideoCommentMapper videoCommentMapper;

    //    @Override
////    public int deleteByPrimaryKey(String videoCommentId,String videoCommentUserId) {
////        return videoCommentMapper.deleteByPrimaryKey(videoCommentId,videoCommentUserId);
////
////    }
    @Override
    public int insert(String videoCommentUserId,String videoCommentVideoId,String videoCommentContent) {
        return 0;
    }


    //添加视频评论
    @Override
    public int insertSelective(VideoComment record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setVideoCommentId(id);
        record.setVideoCommentTime(new Date());
        record.setVideoCommentStatus(0);
        return videoCommentMapper.insertSelective(record);
    }

    @Override
    public VideoComment selectByPrimaryKey(String videoCommentId) {
        return null;
    }


    @Override
    public int updateByPrimaryKeySelective(VideoComment record) {
        return 0;
    }
    //删除视频评论
    @Override
    public int updateByPrimaryKey(String videoCommentId) {
        return videoCommentMapper.updateByPrimaryKey(videoCommentId);
    }
    //根据视频ID查询视频的所有评论
    @Override
    public List<VideoComment> queryVideoCommentByVideoId(String videoId) {
        List<VideoComment> list=videoCommentMapper.queryVideoCommentByVideoId(videoId);
        return list;
    }

    /**
     * 查询所有视频评论
     * @return
     */
    @Override
    public List<VideoComment> queryVideoCommentAll() {
        List<VideoComment> list=videoCommentMapper.queryVideoCommentAll();
        return list;
    }

    //查询视频评论数量
    @Override
    public int queryVideoCommentNum(String videoCommentVideoId) {
        int num = videoCommentMapper.queryVideoCommentNum(videoCommentVideoId);
        return num;
    }
    //根据用户ID查询所有评论
    @Override
    public List<VideoComment> queryVideoCommentByUserId(String userId) {
        List<VideoComment> list = videoCommentMapper.queryVideoCommentByUserId(userId);
        return list;
    }

}