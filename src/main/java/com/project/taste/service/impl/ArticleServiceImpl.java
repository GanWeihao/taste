package com.project.taste.service.impl;

import com.project.taste.mapper.ArticleMapper;
import com.project.taste.model.Article;
import com.project.taste.service.ArticleService;
import com.project.taste.vo.DateVo;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.text.ParseException;
import java.util.*;

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
        Article article = articleMapper.selectByPrimaryKey(articleId);
        if(article.getArticleStatus() == 0){
            article.setArticleStatus(1);
        }else{
            article.setArticleStatus(0);
        }
        return articleMapper.deleteByArticleId(article);
    }

    //添加文章
    @Override
    public String insertSelective(Article record) throws IOException, SolrServerException {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        record.setArticleId(id);
        record.setArticleStatus(0);
        record.setArticleTime(new Date());
        articleMapper.insertSelective(record);
        return id;
    }

    //查询所有文章数量
    @Override
    public int selectArticleNum() {
        return articleMapper.selectArticleNum();
    }

    @Override
    public List selectNumByTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<DateVo> list = articleMapper.selectNumByTime();
        List list1 = new ArrayList();
        for (DateVo dateVo : list) {
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("date", sdf.format(dateVo.getDates()));
            hm.put("num", dateVo.getNum());
            list1.add(hm);
        }
        return list1;

    }

    @Override
    public int deleteByPrimaryKey(String articleId) {
        return 0;
    }

    @Override
    public int insert(Article record) {
        return 0;
    }

    //修改文章
    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return 0;
    }

}