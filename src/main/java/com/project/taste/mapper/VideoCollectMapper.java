package com.project.taste.mapper;

import com.project.taste.model.Video;
import com.project.taste.model.VideoCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("VideoCollectMapper")
public interface VideoCollectMapper {
    int deleteByPrimaryKey(String videoCollectId);

    int insert(VideoCollect record);

    int insertSelective(VideoCollect record);

    VideoCollect selectByPrimaryKey(String videoCollectId);

    int updateByPrimaryKeySelective(VideoCollect record);

    int updateByPrimaryKey(VideoCollect record);
    //根据用户ID查视频收藏
    List<VideoCollect> selectByUserId(String videoCollectUserId);
    // 添加视频收藏
    int insertVideoCollect(VideoCollect record);
    //根据视频ID查收藏数量
    int selectVideoCount(String videoCollectVideoId);
    //删除视频收藏
    int deleteVideoCollect(String videoCollectId);

}