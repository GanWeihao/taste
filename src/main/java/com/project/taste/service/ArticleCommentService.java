package com.project.taste.service;

import com.project.taste.model.ArticleComment;

public interface ArticleCommentService {
    int deleteByPrimaryKey(String articleCommentId);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(String articleCommentId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}