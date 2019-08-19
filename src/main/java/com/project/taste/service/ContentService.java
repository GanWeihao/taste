package com.project.taste.service;

import com.project.taste.model.Content;

public interface ContentService {
    int deleteByPrimaryKey(String contentId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(String contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}