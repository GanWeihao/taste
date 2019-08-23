package com.project.taste.service;

import com.project.taste.model.Category;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(String categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String categoryId);

    //修改类别
    int updateByPrimaryKeySelective(Category record);

    //删除类别
    int updateByPrimaryKey(String categoryId);

    //查询所有类别
    List<Category> queryAll();


}