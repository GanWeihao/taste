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

    List<Category> queryAll();
}