package com.project.taste.mapper;

import com.project.taste.model.UserCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("UserCategoryMapper")
public interface UserCategoryMapper {
    int deleteByPrimaryKey(String userCategoryId);

    int insert(UserCategory record);

    int insertSelective(UserCategory record);

    UserCategory selectByPrimaryKey(String userCategoryId);

    int updateByPrimaryKeySelective(UserCategory record);

    int updateByPrimaryKey(UserCategory record);
}