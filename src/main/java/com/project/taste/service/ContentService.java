package com.project.taste.service;

import com.project.taste.model.Content;

import java.util.List;

public interface ContentService {
    //根据文章ID查询内容
    List<Content> selectByArticleId(String articleId);

    int deleteByPrimaryKey(String contentId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}