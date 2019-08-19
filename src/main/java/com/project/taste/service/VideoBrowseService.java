package com.project.taste.service;

import com.project.taste.model.VideoBrowse;

public interface VideoBrowseService {
    int deleteByPrimaryKey(String videoBrowseId);

    int insert(VideoBrowse record);

    int insertSelective(VideoBrowse record);

    VideoBrowse selectByPrimaryKey(String videoBrowseId);

    int updateByPrimaryKeySelective(VideoBrowse record);

    int updateByPrimaryKey(VideoBrowse record);
}