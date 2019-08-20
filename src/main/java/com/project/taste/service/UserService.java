package com.project.taste.service;

import com.project.taste.model.User;

public interface UserService {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userName, String userPassword);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}