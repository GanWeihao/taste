package com.project.taste.service;

import com.project.taste.model.Message;

import java.util.List;

public interface MessageService {
    int deleteByPrimaryKey(String messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    //根据用户ID查询用户的所有已读和未读信息
    List<Message> queryMessageByUserId(String userId);
}