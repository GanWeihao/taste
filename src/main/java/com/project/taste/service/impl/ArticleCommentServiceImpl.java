package com.project.taste.service.impl;
import com.project.taste.mapper.ArticleCommentMapper;
import com.project.taste.model.ArticleComment;
import com.project.taste.model.User;
import com.project.taste.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    //删除文章评论
    @Override
    public int deleteArticleComment(String articleCommentId){
        return  articleCommentMapper.deleteArticleComment(articleCommentId);
    }
    @Override
    public int deleteByPrimaryKey(String articleCommentId) {
        return 0;
    }
    @Override
    public int insert(ArticleComment record) {
        return 0;
    }
    //添加文章评论
    @Override
    public int insertSelective(ArticleComment record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setArticleCommentId(id);
        record.setArticleCommentStatus(0);
        record.setArticleCommentTime(new Date());
        return articleCommentMapper.insertSelective(record);
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
    //根据文章ID查询文章评论
    @Override
    public List<ArticleComment> queryByIdComment(String articleCommentArticleId){
        return  articleCommentMapper.queryByIdComment(articleCommentArticleId);
    }
    //根据用户ID查询文章评论
    public List<ArticleComment>  queryUserByIdComment(String articleCommentUserId){
        return  articleCommentMapper.queryUserByIdComment(articleCommentUserId);
    }
    //根据文章ID查询评论数量
    public int queryCommentNumber(String articleCommentArticleId){
        return  articleCommentMapper.queryCommentNumber(articleCommentArticleId);
    }

}