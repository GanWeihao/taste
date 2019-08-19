package com.project.taste.mapper;

import com.project.taste.model.VideoBrowse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("VideoBrowseMapper")
public interface VideoBrowseMapper {
    int deleteByPrimaryKey(String videoBrowseId);

    int insert(VideoBrowse record);

    int insertSelective(VideoBrowse record);

    VideoBrowse selectByPrimaryKey(String videoBrowseId);

    int updateByPrimaryKeySelective(VideoBrowse record);

    int updateByPrimaryKey(VideoBrowse record);
}