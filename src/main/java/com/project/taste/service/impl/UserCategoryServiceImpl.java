package com.project.taste.service.impl;

import com.project.taste.mapper.UserCategoryMapper;
import com.project.taste.model.UserCategory;
import com.project.taste.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {
    @Autowired
    UserCategoryMapper userCategoryMapper;

    //查询用户的喜好
    @Override
    public List<UserCategory> selectByUserId(String userCategoryUserId) {
        return userCategoryMapper.selectByUserId(userCategoryUserId);
    }

    @Override
    public int deleteByPrimaryKey(String userCategoryId) {
        return 0;
    }

    @Override
    public int insert(UserCategory record) {
        return 0;
    }

    @Override
    public int insertSelective(UserCategory record) {
        return 0;
    }

    @Override
    public UserCategory selectByPrimaryKey(String userCategoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserCategory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserCategory record) {
        return 0;
    }
}