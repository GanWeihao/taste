package com.project.taste.service;

import com.project.taste.model.Attention;

public interface AttentionService {
    int deleteByPrimaryKey(String attentionId);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(String attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}