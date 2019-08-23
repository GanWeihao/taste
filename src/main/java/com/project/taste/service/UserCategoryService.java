package com.project.taste.service;

import com.project.taste.model.UserCategory;

import java.util.List;

public interface UserCategoryService {
    //查询用户喜好
    List<UserCategory> selectByUserId(String userCategoryUserId);

    int deleteByPrimaryKey(String userCategoryId);

    int insert(UserCategory record);

    int insertSelective(UserCategory record);

    UserCategory selectByPrimaryKey(String userCategoryId);

    int updateByPrimaryKeySelective(UserCategory record);

    int updateByPrimaryKey(UserCategory record);
}