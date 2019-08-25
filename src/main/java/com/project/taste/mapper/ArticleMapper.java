package com.project.taste.mapper;

import com.project.taste.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ArticleMapper")
public interface ArticleMapper {
    //查询所有文章（带分页）
    List<Article> selectAll();
    //根据类别查所有文章(带分页)
    List<Article> selectByCategoryId(String articleCategoryId);
    //根据文章ID查询文章
    Article selectByPrimaryKey(String articleId);
    //根据ID删除文章
    int deleteByArticleId(String articleId);
    //添加文章
    int insertSelective(Article record);
    //查询所有文章数量
    int selectArticleNum();
    //根据日期查数量
    List selectNumByTime();


    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    //修改文章
    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}