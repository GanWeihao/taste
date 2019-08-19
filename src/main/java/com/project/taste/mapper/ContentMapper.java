package com.project.taste.mapper;

import com.project.taste.model.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("ContentMapper")
public interface ContentMapper {
    int deleteByPrimaryKey(String contentId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}