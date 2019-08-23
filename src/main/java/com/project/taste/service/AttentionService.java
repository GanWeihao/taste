package com.project.taste.service;

import com.project.taste.model.Attention;

public interface AttentionService {
    //取消关注
    int deleteByPrimaryKey(String attentionUserId,String attentionTouserId);
    //添加关注
    int insert(String attentionUserId,String attentionTouserId);
    //查询用户关注人数
    int queryNum(String userId);
    //查询用户粉丝人数
    int queryNum1(String userId);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(String attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}