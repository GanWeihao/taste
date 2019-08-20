package com.project.taste.mapper;

import com.project.taste.model.ArticleBrowse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ArticleBrowseMapper")
public interface ArticleBrowseMapper {
    //根据用户ID查询文章浏览记录
    List<ArticleBrowse> selectByUserId(String articleBrowseUserId);
    //根据文章ID查询浏览数量
    int selectNumByArticleId(String articleBrowseArticleId);

    int deleteByPrimaryKey(String articleBrowseId);

    int insert(ArticleBrowse record);

    int insertSelective(ArticleBrowse record);

    ArticleBrowse selectByPrimaryKey(String articleBrowseId);

    int updateByPrimaryKeySelective(ArticleBrowse record);

    int updateByPrimaryKey(ArticleBrowse record);
}