package com.project.taste.service;

import com.project.taste.model.ArticleBrowse;

import java.util.List;

public interface ArticleBrowseService {
    //根据用户ID查询文章浏览记录
    List<ArticleBrowse> selectByUserId(String articleBrowseUserId);
    //根据文章ID查询浏览数量
    int selectNumByArticleId(String articleBrowseArticleId);
    //删除浏览记录
    int deleteByArticleBrowseId(String articleBrowseId);
    int deleteByArticleBrowseId2(List<String> articleBrowseList);
    //删除用户所有浏览记录
    int deleteByUserId(String articleBrowseUserId);
    //添加文章浏览记录
    int insertSelective(ArticleBrowse record);

    int insert(ArticleBrowse record);

    ArticleBrowse selectByPrimaryKey(String articleBrowseId);

    int updateByPrimaryKeySelective(ArticleBrowse record);

    int updateByPrimaryKey(ArticleBrowse record);
}