package com.project.taste.mapper;

import com.project.taste.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("CategoryMapper")
public interface CategoryMapper {

    //查询所有类别
    List<Category> queryAll();

    int deleteByPrimaryKey(String categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String categoryId);

    //更新类别
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}