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

    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}