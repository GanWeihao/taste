package com.project.taste.service.impl;

import com.project.taste.mapper.ArticleBrowseMapper;
import com.project.taste.model.ArticleBrowse;
import com.project.taste.service.ArticleBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleBrowseServiceImpl implements ArticleBrowseService {

    @Autowired
    ArticleBrowseMapper articleBrowseMapper;

    //根据用户ID查询文章浏览记录
    @Override
    public List<ArticleBrowse> selectByUserId(String articleBrowseUserId) {
        return articleBrowseMapper.selectByUserId(articleBrowseUserId);
    }

    //根据文章ID查询浏览数量
    @Override
    public int selectNumByArticleId(String articleBrowseArticleId) {
        return articleBrowseMapper.selectNumByArticleId(articleBrowseArticleId);
    }

    //删除浏览记录
    @Override
    public int deleteByArticleBrowseId(String articleBrowseId) {
        return articleBrowseMapper.deleteByArticleBrowseId(articleBrowseId);
    }
    //删除浏览记录
    @Override
    public int deleteByArticleBrowseId2(List<String> articleBrowseList) {
        return articleBrowseMapper.deleteByArticleBrowseId2(articleBrowseList);
    }
    //删除用户所有浏览记录
    @Override
    public int deleteByUserId(String articleBrowseUserId) {
        return articleBrowseMapper.deleteByUserId(articleBrowseUserId);
    }

    //添加浏览记录
    @Override
    public int insertSelective(ArticleBrowse record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setArticleBrowseId(id);
        record.setArticleBrowseTime(new Date());
        return articleBrowseMapper.insertSelective(record);
    }

    @Override
    public int insert(ArticleBrowse record) {
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