package com.project.taste.mapper;

import com.project.taste.model.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("VideoMapper")
public interface VideoMapper {
    int deleteByPrimaryKey(String videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(String videoId);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    //查询所有视频
    List<Video> queryVideoAll();
    //根据用户ID查询该用户上传的视频数量
    int queryVideoNum(String userId);
    //根据视频ID查询视频详情
    Video queryVideoById(String videoId);
    //根据用户id查询用户上传所有视频
    List<Video> queryVideoAllByid(String userId);
}