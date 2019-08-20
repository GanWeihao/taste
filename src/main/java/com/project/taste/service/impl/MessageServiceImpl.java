package com.project.taste.service.impl;

import com.project.taste.mapper.MessageMapper;
import com.project.taste.model.Message;
import com.project.taste.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(String messageId) {
        return 0;
    }

    @Override
    public int insert(Message record) {
        return 0;
    }

    @Override
    public int insertSelective(Message record) {
        return 0;
    }

    @Override
    public Message selectByPrimaryKey(String messageId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return 0;
    }

    /**
     * 根据用户ID查询用户的所有已读和未读信息
     * @param userId
     * @return
     */
    @Override
    public List<Message> queryMessageByUserId(String userId) {
        List<Message> list=messageMapper.queryMessageByUserId(userId);
        return list;
    }

    /**
     * 据消息ID查询消息详情
     * @param messageId
     * @return
     */
    @Override
    public Message queryMessageByMessageId(String messageId) {
        Message message = messageMapper.queryMessageByMessageId(messageId);
        if(message!=null){
            updateMessage(messageId);
        }
        return message;
    }

    /**
     * 根据消息ID更改消息状态
     * @param messageId
     * @return
     */
    @Override
    public int updateMessage(String messageId) {
        int row=messageMapper.updateMessage(messageId);
        return row;
    }
}