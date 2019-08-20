package com.project.taste.service;

import com.project.taste.model.Article;

import java.util.List;

public interface ArticleService {
    //查询所有文章（带分页）
    List<Article> selectAll();
    //根据类别ID查文章（带分页）
    List <Article> selectByCategoryId(String articleCategoryId);
    //根据文章ID查询文章
    Article selectByPrimaryKey(String articleId);
    //根据ID删除文章
    int deleteByArticleId(String articleId);

    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}