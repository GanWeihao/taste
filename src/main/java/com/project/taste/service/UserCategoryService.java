package com.project.taste.service;

import com.project.taste.model.UserCategory;

public interface UserCategoryService {
    int deleteByPrimaryKey(String userCategoryId);

    int insert(UserCategory record);

    int insertSelective(UserCategory record);

    UserCategory selectByPrimaryKey(String userCategoryId);

    int updateByPrimaryKeySelective(UserCategory record);

    int updateByPrimaryKey(UserCategory record);
}