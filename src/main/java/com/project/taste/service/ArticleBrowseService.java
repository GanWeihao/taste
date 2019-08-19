package com.project.taste.service;

import com.project.taste.model.ArticleBrowse;

public interface ArticleBrowseService {
    int deleteByPrimaryKey(String articleBrowseId);

    int insert(ArticleBrowse record);

    int insertSelective(ArticleBrowse record);

    ArticleBrowse selectByPrimaryKey(String articleBrowseId);

    int updateByPrimaryKeySelective(ArticleBrowse record);

    int updateByPrimaryKey(ArticleBrowse record);
}