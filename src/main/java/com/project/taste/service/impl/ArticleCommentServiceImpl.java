package com.project.taste.service.impl;

import com.project.taste.model.ArticleComment;
import com.project.taste.service.ArticleCommentService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Override
    public int deleteByPrimaryKey(String articleCommentId) {
        return 0;
    }

    @Override
    public int insert(ArticleComment record) {
        return 0;
    }

    @Override
    public int insertSelective(ArticleComment record) {
        return 0;
    }

    @Override
    public ArticleComment selectByPrimaryKey(String articleCommentId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleComment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ArticleComment record) {
        return 0;
    }
}