package com.project.taste.mapper;

import com.project.taste.model.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ContentMapper")
public interface ContentMapper {
    //根据文章ID查询内容
    List<Content> selectByArticleId(String articleId);

    int deleteByPrimaryKey(String contentId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}