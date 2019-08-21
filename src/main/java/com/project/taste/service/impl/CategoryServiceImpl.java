package com.project.taste.service.impl;

import com.project.taste.mapper.CategoryMapper;
import com.project.taste.model.Category;
import com.project.taste.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(String categoryId) {
        return 0;
    }

    @Override
    public int insert(Category record) {
        return 0;
    }

    //添加类别的
    @Override
    public int insertSelective(Category record) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        record.setCategoryId(id);
        record.setCategoryStatus(0);
//        record.setCategoryName();
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(String categoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }
    //查询所有类别
    @Override
    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }

}