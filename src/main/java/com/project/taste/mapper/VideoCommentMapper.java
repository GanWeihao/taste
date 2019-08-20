package com.project.taste.mapper;

import com.project.taste.model.VideoComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("VideoCommentMapper")
public interface VideoCommentMapper {
    int deleteByPrimaryKey(String videoCommentId);

    int insert(VideoComment record);

    int insertSelective(VideoComment record);

    VideoComment selectByPrimaryKey(String videoCommentId);

    int updateByPrimaryKeySelective(VideoComment record);

    int updateByPrimaryKey(VideoComment record);
    //根据视频ID查询视频的所有评论
    List<VideoComment> queryVideoCommentByVideoId(String videoId);
    //查询所有视频评论
    List<VideoComment> queryVideoCommentAll();
    //查询视频评论数量
    int queryVideoCommentNum();
}