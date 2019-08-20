package com.project.taste.service;

import com.project.taste.model.User;

import java.util.Date;

public interface UserService {
    int deleteByPrimaryKey(String userId);

    int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime);

    int insertSelective(User record);

    User selectByPrimaryKey1(String userTelephone);

    User selectByPrimaryKey(String userName, String userPassword);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}