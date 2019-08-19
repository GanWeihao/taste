package com.project.taste.service.impl;

import com.project.taste.model.Attention;
import com.project.taste.service.AttentionService;
import org.springframework.stereotype.Service;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Override
    public int deleteByPrimaryKey(String attentionId) {
        return 0;
    }

    @Override
    public int insert(Attention record) {
        return 0;
    }

    @Override
    public int insertSelective(Attention record) {
        return 0;
    }

    @Override
    public Attention selectByPrimaryKey(String attentionId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Attention record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Attention record) {
        return 0;
    }
}