package com.project.taste.mapper;

import com.project.taste.model.Article;
import com.project.taste.model.ArticleCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ArticleCollectMapper")
public interface ArticleCollectMapper {
    int deleteByPrimaryKey(String articleCollectId);

    int insert(ArticleCollect record);

    int insertSelective(ArticleCollect record);

    ArticleCollect selectByPrimaryKey(String articleCollectId);

    int updateByPrimaryKeySelective(ArticleCollect record);

    int updateByPrimaryKey(ArticleCollect record);

    // 根据用户id查询所有文章收藏
    List<ArticleCollect> selectArticleByUId(String articleCollectUserId);
    //根据文章ID查收藏数量
    int selectCount(String articleCollectArticleId);
    //添加文章收藏
    int insertCollect(ArticleCollect articleCollect);
    //删除文章收藏
    int deleteCollect(String articleCollectId);
}