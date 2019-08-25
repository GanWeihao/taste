package com.project.taste.mapper;

import com.project.taste.model.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("ContentMapper")
public interface ContentMapper {
    //根据文章ID查询内容
    List<Content> selectByArticleId(String articleId);
    //根据文章ID删除内容
    int deleteByArticleId(String contentArticleId);
    //添加文章内容
    int insertBatch(List<Content> list);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
    //查询文章所有内容
    public  List<Content> selectAllContent();
}