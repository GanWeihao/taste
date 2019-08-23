package com.project.taste.service;

import com.project.taste.model.ArticleComment;

import java.util.List;

public interface ArticleCommentService {
    //删除文章评论
    int deleteArticleComment(String articleCommentId);
    int deleteByPrimaryKey(String articleCommentId);

    int insert(ArticleComment record);
    //添加文章评论
    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(String articleCommentId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
    //根据文章ID查询评论
    public List<ArticleComment> queryByIdComment(String articleCommentArticleId);
    //根据用户ID查询文章评论
    public List<ArticleComment>  queryUserByIdComment(String articleCommentUserId);
    //根据文章ID查询评论数量
    public int queryCommentNumber(String articleCommentArticleId);
}