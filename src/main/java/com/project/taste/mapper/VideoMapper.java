package com.project.taste.mapper;

import com.project.taste.model.Video;
import com.project.taste.vo.DateVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("VideoMapper")
public interface VideoMapper {
    //根据类别查询视频
    List<Video> selectAllByCategoryId(String videoCategoryId);
    //查询视频数量
    int selectVideoNum();
    //根据时间查询用户数量
    List<DateVo> selectNumByTime();

    int deleteByPrimaryKey(String videoId);

    int insert(Video record);
    //添加视频
    int insertSelective(Video record);
    //根据视频标题查询视频
    Video selectByPrimaryKey(String videoTitle);

    int updateByPrimaryKeySelective(Video record);
    //删除视频
    int updateByPrimaryKey(String videoId);

    //查询所有视频
    List<Video> queryVideoAll();
    //根据用户ID查询该用户上传的视频数量
    int queryVideoNum(String userId);
    //根据视频ID查询视频详情
    Video queryVideoById(String videoId);
    //根据用户id查询用户上传所有视频
    List<Video> queryVideoAllByid(String userId);
}