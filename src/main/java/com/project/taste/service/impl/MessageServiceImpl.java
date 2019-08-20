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

    @Override
    public List<Message> queryMessageByUserId(String userId) {
        List<Message> list=messageMapper.queryMessageByUserId(userId);
        return list;
    }
}