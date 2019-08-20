package com.project.taste.mapper;

import com.project.taste.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Mapper
@Component("UserMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String userId);
   // 注册用户
    int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime,Integer userRank ,Integer userStatus);
    //添加用户2
    int insertSelective(User record);
    //用户登入
    User selectByPrimaryKey(String userName,String userPassword);
    //短信登入
    User selectByPrimaryKey1(String userTelephone);
    //查询用户数量
    int querynum();
    
    //根据ID查询用户详情
    User selectById(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}