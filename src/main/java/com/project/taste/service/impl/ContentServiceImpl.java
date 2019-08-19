package com.project.taste.service.impl;

import com.project.taste.model.Content;
import com.project.taste.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

    @Override
    public int deleteByPrimaryKey(String contentId) {
        return 0;
    }

    @Override
    public int insert(Content record) {
        return 0;
    }

    @Override
    public int insertSelective(Content record) {
        return 0;
    }

    @Override
    public Content selectByPrimaryKey(String contentId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Content record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Content record) {
        return 0;
    }
}