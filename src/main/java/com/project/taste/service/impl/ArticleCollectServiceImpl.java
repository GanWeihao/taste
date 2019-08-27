package com.project.taste.service.impl;

import com.project.taste.mapper.ArticleCollectMapper;
import com.project.taste.model.Article;
import com.project.taste.model.ArticleCollect;
import com.project.taste.service.ArticleCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleCollectServiceImpl implements ArticleCollectService {
    @Autowired
    ArticleCollectMapper articleCollectMapper;

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
    /**
     * 根据用户id查询所有文章收藏
     */
    @Override
    public List<ArticleCollect> selectArticleByUId(String articleCollectUserId) {
        return articleCollectMapper.selectArticleByUId(articleCollectUserId);
    }
    /**
     * 根据文章ID查收藏数量
     */
    @Override
    public int selectCount(String articleCollectArticleId){
        return articleCollectMapper.selectCount(articleCollectArticleId);
    }

    /**
     * 添加文章收藏
     */
    @Override
    public int insertCollect(ArticleCollect articleCollect) {
        ArticleCollect art=new ArticleCollect();
        String id = UUID.randomUUID().toString().replaceAll("-","");
        art.setArticleCollectId(id);
        art.setArticleCollectTime(new Date());
        art.setArticleCollectUserId(articleCollect.getArticleCollectUserId());
        art.setArticleCollectArticleId(articleCollect.getArticleCollectArticleId());
        return  articleCollectMapper.insertCollect(art);
    }
    /**
     * 删除文章收藏
     */
    @Override
    public int deleteCollect(String articleCollectId){
        return  articleCollectMapper.deleteCollect(articleCollectId);
    }


}