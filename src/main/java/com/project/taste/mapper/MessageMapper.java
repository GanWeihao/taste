package com.project.taste.mapper;

import com.project.taste.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("MessageMapper")
public interface MessageMapper {
    int deleteByPrimaryKey(String messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    //根据用户ID查询用户的所有已读和未读信息
    List<Message> queryMessageByUserId(String userId);
}