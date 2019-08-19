package com.project.taste.mapper;

import com.project.taste.model.VideoComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("VideoCommentMapper")
public interface VideoCommentMapper {
    int deleteByPrimaryKey(String videoCommentId);

    int insert(VideoComment record);

    int insertSelective(VideoComment record);

    VideoComment selectByPrimaryKey(String videoCommentId);

    int updateByPrimaryKeySelective(VideoComment record);

    int updateByPrimaryKey(VideoComment record);
}