package com.project.taste.service.impl;

import com.project.taste.model.VideoBrowse;
import com.project.taste.service.VideoBrowseService;
import org.springframework.stereotype.Service;

@Service
public class VideoBrowseServiceImpl implements VideoBrowseService {

    @Override
    public int deleteByPrimaryKey(String videoBrowseId) {
        return 0;
    }

    @Override
    public int insert(VideoBrowse record) {
        return 0;
    }

    @Override
    public int insertSelective(VideoBrowse record) {
        return 0;
    }

    @Override
    public VideoBrowse selectByPrimaryKey(String videoBrowseId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(VideoBrowse record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(VideoBrowse record) {
        return 0;
    }
}