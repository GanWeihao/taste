package com.project.taste.service.impl;

import com.project.taste.mapper.AttentionMapper;
import com.project.taste.model.Attention;
import com.project.taste.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    AttentionMapper attentionMapper;
    //取消关注
    @Override
    public int deleteByPrimaryKey(String attentionUserId,String attentionTouserId) {
        return attentionMapper.deleteByPrimaryKey(attentionUserId,attentionTouserId);
    }
    //添加关注
    @Override
    public int insert(String attentionUserId,String attentionTouserId) {
        String id= UUID.randomUUID().toString().replaceAll("-","");
        Attention record=new Attention();
        record.setAttentionId(id);
        record.setAttentionUserId(attentionUserId);
        record.setAttentionTouserId(attentionTouserId);
        return attentionMapper.insert(record);
    }
    //查询用户关注人数
    @Override
    public int queryNum(String userId){
        return attentionMapper.queryNum(userId);
    }

    //查询用户粉丝人数
    @Override
    public int queryNum1(String userId){
        return attentionMapper.queryNum1(userId);
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