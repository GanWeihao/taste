package com.project.taste.service.impl;

import com.project.taste.mapper.ArticleMapper;
import com.project.taste.model.Article;
import com.project.taste.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    //查询所有文章（带分页）
    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    //根据类别查ID所有文章（带分页）
    @Override
    public List<Article> selectByCategoryId(String articleCategoryId) {
        return articleMapper.selectByCategoryId(articleCategoryId);
    }

    //根据文章ID查询文章
    @Override
    public Article selectByPrimaryKey(String articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    //根据文章ID删除文章
    @Override
    public int deleteByArticleId(String articleId) {
        return articleMapper.deleteByArticleId(articleId);
    }

    //添加文章
    @Override
    public int insertSelective(Article record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setArticleId(id);
        record.setArticleStatus(0);
        record.setArticleTime(new Date());
        return articleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String articleId) {
        return 0;
    }

    @Override
    public int insert(Article record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return 0;
    }
}