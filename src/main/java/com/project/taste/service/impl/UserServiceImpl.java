package com.project.taste.service.impl;

import com.project.taste.mapper.UserMapper;
import com.project.taste.model.User;
import com.project.taste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    //查询用户数量
    @Override
    public int querynum() {
        return userMapper.querynum();
    }

    //用户注册
    @Override
    public int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime) {
        int s = userMapper.insert(userId, userName, userTelphone, userEmail, userPassword, userHeadurl, userTime, 1, 0);
        return s;
    }

    //添加用户2
    @Override
    public int insertSelective(User record) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        record.setUserId(id);
        record.setUserName(record.getUserTelphone());
        record.setUserTime(new Date());
        record.setUserStatus(0);
        record.setUserRank(1);
        return userMapper.insertSelective(record);
    }


    //用户登入
    @Override
    public User selectByPrimaryKey(String userName, String userPassword) {
        User user = userMapper.selectByPrimaryKey(userName, userPassword);
        return user;
    }

    //短信登入
    @Override
    public User selectByPrimaryKey1(String userTelephone) {
        User user = userMapper.selectByPrimaryKey1(userTelephone);
        return user;
    }

    //根据id查询用户详情
    @Override
    public User selectById(String userId) {
        return userMapper.selectById(userId);
    }
    //根据用户名 用户邮箱 用户电话 查询用户信息

    @Override
    public User queryAlltiaojian(String userName, String userTelphone, String userEmail) {
        return userMapper.queryAlltiaojian(userName, userTelphone, userEmail);
    }

    //恢复或禁封用户

    @Override
    public int updateByStatus(String userId, Integer userStatus) {
        return userMapper.updateByStatus(userId, userStatus);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}