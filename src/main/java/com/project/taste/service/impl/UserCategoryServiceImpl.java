package com.project.taste.service.impl;

import com.project.taste.model.UserCategory;
import com.project.taste.service.UserCategoryService;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {

    @Override
    public int deleteByPrimaryKey(String userCategoryId) {
        return 0;
    }

    @Override
    public int insert(UserCategory record) {
        return 0;
    }

    @Override
    public int insertSelective(UserCategory record) {
        return 0;
    }

    @Override
    public UserCategory selectByPrimaryKey(String userCategoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserCategory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserCategory record) {
        return 0;
    }
}