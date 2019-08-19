package com.project.taste.mapper;

import com.project.taste.model.ArticleCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("ArticleCollectMapper")
public interface ArticleCollectMapper {
    int deleteByPrimaryKey(String articleCollectId);

    int insert(ArticleCollect record);

    int insertSelective(ArticleCollect record);

    ArticleCollect selectByPrimaryKey(String articleCollectId);

    int updateByPrimaryKeySelective(ArticleCollect record);

    int updateByPrimaryKey(ArticleCollect record);
}