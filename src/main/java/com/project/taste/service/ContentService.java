package com.project.taste.service;

import com.project.taste.model.Content;

import java.util.List;

public interface ContentService {
    //根据文章ID查询内容
    List<Content> selectByArticleId(String articleId);
    //根据文章ID删除内容
    int deleteByArticleId(String contentArticleId);
    //添加文章内容
    int insertBatch(List<Content> list);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}