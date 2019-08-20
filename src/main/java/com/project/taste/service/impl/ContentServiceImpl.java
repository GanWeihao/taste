package com.project.taste.service.impl;

import com.project.taste.mapper.ContentMapper;
import com.project.taste.model.Content;
import com.project.taste.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;

    //根据文章ID查询内容
    @Override
    public List<Content> selectByArticleId(String articleId) {
        return contentMapper.selectByArticleId(articleId);
    }
    //根据文章ID删除内容
    @Override
    public int deleteByArticleId(String contentArticleId) {
        return contentMapper.deleteByArticleId(contentArticleId);
    }

    @Override
    public int insert(Content record) {
        return 0;
    }

    @Override
    public int insertSelective(Content record) {
        return 0;
    }

    @Override
    public Content selectByPrimaryKey(String contentId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Content record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Content record) {
        return 0;
    }
}