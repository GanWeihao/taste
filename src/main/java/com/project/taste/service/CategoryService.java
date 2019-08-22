package com.project.taste.service;

import com.project.taste.model.Category;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(String categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    //查询所有类别
    List<Category> queryAll();
    //添加类别

}