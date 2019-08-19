package com.project.taste.service;

import com.project.taste.model.ArticleCollect;

public interface ArticleCollectService {
    int deleteByPrimaryKey(String articleCollectId);

    int insert(ArticleCollect record);

    int insertSelective(ArticleCollect record);

    ArticleCollect selectByPrimaryKey(String articleCollectId);

    int updateByPrimaryKeySelective(ArticleCollect record);

    int updateByPrimaryKey(ArticleCollect record);
}