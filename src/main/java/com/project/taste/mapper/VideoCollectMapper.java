package com.project.taste.mapper;

import com.project.taste.model.VideoCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("VideoCollectMapper")
public interface VideoCollectMapper {
    int deleteByPrimaryKey(String videoCollectId);

    int insert(VideoCollect record);

    int insertSelective(VideoCollect record);

    VideoCollect selectByPrimaryKey(String videoCollectId);

    int updateByPrimaryKeySelective(VideoCollect record);

    int updateByPrimaryKey(VideoCollect record);
}