package com.project.taste.mapper;

import com.project.taste.model.VideoBrowse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("VideoBrowseMapper")
public interface VideoBrowseMapper {

    //删除视频浏览记录
    int deleteByPrimaryKey(String videoBrowseId);

    //添加视频浏览记录
    int insert(VideoBrowse record);

    int insertSelective(VideoBrowse record);

    VideoBrowse selectByPrimaryKey(String videoBrowseId);

    int updateByPrimaryKeySelective(VideoBrowse record);

    int updateByPrimaryKey(VideoBrowse record);

    //根据用户ID查询用户浏览视频记录
    List<VideoBrowse> queryVideoBrowseByUserId(String userId);
    //根据用户ID查询用户浏览视频数量
    int queryVideoBrowseNum(String userId);
}