package com.project.taste.service.impl;

import com.project.taste.mapper.UserMapper;
import com.project.taste.model.User;
import com.project.taste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper  userMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    //用户注册
    @Override
    public int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime) {
        int s=userMapper.insert(userId,userName,userTelphone,userEmail,userPassword,userHeadurl,userTime,1,1);
        return s;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }
    //用户登入
    @Override
    public User selectByPrimaryKey(String userName,String userPassword) {
       User user=userMapper.selectByPrimaryKey(userName,userPassword);
       return  user;
    }

    //短信登入
    @Override
    public User selectByPrimaryKey1(String userTelephone){
       User user=userMapper.selectByPrimaryKey1(userTelephone);
       return  user;
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