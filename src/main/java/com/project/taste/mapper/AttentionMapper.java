package com.project.taste.mapper;

import com.project.taste.model.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("AttentionMapper")
public interface AttentionMapper {
    int deleteByPrimaryKey(String attentionId);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(String attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}