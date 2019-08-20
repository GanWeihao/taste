package com.project.taste.mapper;

import com.project.taste.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("UserMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);
    //用户登入
    User selectByPrimaryKey(String userName,String userPassword);
    //短信登入
    User selectByPrimaryKey1(String userTelephone);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}