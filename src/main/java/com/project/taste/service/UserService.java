package com.project.taste.service;

import com.project.taste.model.User;

import java.util.Date;

public interface UserService {
    int deleteByPrimaryKey(String userId);
    //注册用户
    int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime);

    //根据手机号添加用户
    int insertSelective(User record);
    //手机号登入
    User selectByPrimaryKey1(String userTelephone);
    //用户登入
    User selectByPrimaryKey(String userName, String userPassword);
    //查询用户数量
    int querynum();
    //根据Id查询用户详情
    User selectById(String userId);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}