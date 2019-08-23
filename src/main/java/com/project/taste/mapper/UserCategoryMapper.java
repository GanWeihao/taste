package com.project.taste.mapper;

import com.project.taste.model.UserCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("UserCategoryMapper")
public interface UserCategoryMapper {

    //删除用户喜好
    int deleteByPrimaryKey(String userCategoryId);
    //查询用户喜好
    List<UserCategory> selectByUserId(String userCategoryUserId);

    int insert(UserCategory record);

    int insertSelective(UserCategory record);

    UserCategory selectByPrimaryKey(String userCategoryId);

    int updateByPrimaryKeySelective(UserCategory record);

    int updateByPrimaryKey(UserCategory record);
}