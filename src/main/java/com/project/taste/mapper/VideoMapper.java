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
}