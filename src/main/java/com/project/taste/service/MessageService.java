package com.project.taste.service;

import com.project.taste.model.Message;

import java.util.List;

public interface MessageService {
    //删除消息
    int deleteByPrimaryKey(String messageId);
    //添加消息
    int insert(String messageContent,String messageTitle,String messageUserId);
    //查看用户所有消息
    List queryAllByUserId(String messageUserId);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    //根据用户ID查询用户的所有已读和未读信息
    List<Message> queryMessageByUserId(String userId);
    //根据文章ID查询文章详情
    Message queryMessageByMessageId(String messageId);
    //根据消息ID更改消息状态
    int updateMessage(String messageId);
    //查询未读信息数量
    int queryMessageNum(String userId);
}