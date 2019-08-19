package com.project.taste.service.impl;

import com.project.taste.model.ArticleCollect;
import com.project.taste.service.ArticleCollectService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCollectServiceImpl implements ArticleCollectService {

    @Override
    public int deleteByPrimaryKey(String articleCollectId) {
        return 0;
    }

    @Override
    public int insert(ArticleCollect record) {
        return 0;
    }

    @Override
    public int insertSelective(ArticleCollect record) {
        return 0;
    }

    @Override
    public ArticleCollect selectByPrimaryKey(String articleCollectId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleCollect record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ArticleCollect record) {
        return 0;
    }
}