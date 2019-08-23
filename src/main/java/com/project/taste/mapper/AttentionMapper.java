package com.project.taste.mapper;

import com.project.taste.model.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("AttentionMapper")
public interface AttentionMapper {

    //取消关注
    int deleteByPrimaryKey(Attention attention);
    //添加关注
    int insert(Attention record);
    //查询用户关注人数
    int queryNum(String userId);

    //查询用户粉丝人数
    int queryNum1(String userId);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(String attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}