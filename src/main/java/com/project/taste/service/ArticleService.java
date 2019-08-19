package com.project.taste.service;

import com.project.taste.model.Article;

import java.util.List;

public interface ArticleService {
    //查询所有文章（带分页）
    List<Article> selectAll();
    //根据类别ID查文章（带分页）
    List <Article> selectByCategoryId(String articleCategoryId);

    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}