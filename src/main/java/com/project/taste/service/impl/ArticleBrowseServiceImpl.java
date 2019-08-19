package com.project.taste.service.impl;

import com.project.taste.model.ArticleBrowse;
import com.project.taste.service.ArticleBrowseService;
import org.springframework.stereotype.Service;

@Service
public class ArticleBrowseServiceImpl implements ArticleBrowseService {

    @Override
    public int deleteByPrimaryKey(String articleBrowseId) {
        return 0;
    }

    @Override
    public int insert(ArticleBrowse record) {
        return 0;
    }

    @Override
    public int insertSelective(ArticleBrowse record) {
        return 0;
    }

    @Override
    public ArticleBrowse selectByPrimaryKey(String articleBrowseId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleBrowse record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ArticleBrowse record) {
        return 0;
    }
}