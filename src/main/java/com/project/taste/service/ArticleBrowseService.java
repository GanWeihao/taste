package com.project.taste.service;

import com.project.taste.model.ArticleBrowse;

import java.util.List;

public interface ArticleBrowseService {
    //根据用户ID查询文章浏览记录
    List<ArticleBrowse> selectByUserId(String articleBrowseUserId);


    int deleteByPrimaryKey(String articleBrowseId);

    int insert(ArticleBrowse record);

    int insertSelective(ArticleBrowse record);

    ArticleBrowse selectByPrimaryKey(String articleBrowseId);

    int updateByPrimaryKeySelective(ArticleBrowse record);

    int updateByPrimaryKey(ArticleBrowse record);
}