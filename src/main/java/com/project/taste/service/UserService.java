package com.project.taste.service;

import com.project.taste.model.User;
import com.project.taste.vo.DateVo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(String userId);

    //查询所有用户
    List<User> selectAll();

    //注册用户
    int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime);

    //根据手机号添加用户
    String insertSelective(User record);

    //手机号登入
    User selectByPrimaryKey1(String userTelephone);

    //用户登入
    User selectByPrimaryKey(User user);

    //查询用户数量
    int querynum();

    //根据Id查询用户详情
    User selectById(String userId);

    //根据用户名 手机号 用户邮箱查询用户
    List queryAlltiaojian(User user);
    //模糊搜索
    List queryAlltiaojian2(User user);

    //恢复或禁封用户
    int updateByStatus(User user);
    //根据用户Id 查询所有的关注
    List<User> attention(String userId);
    //根据用户Id 查询所有的粉丝
    List<User> attention1(String userId);

    //根据时间查询用户数量
    List selectNumByTime() throws ParseException;

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}