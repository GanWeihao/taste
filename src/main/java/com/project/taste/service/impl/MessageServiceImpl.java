package com.project.taste.service.impl;

import com.project.taste.mapper.MessageMapper;
import com.project.taste.model.Message;
import com.project.taste.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;
    //删除消息
    @Override
    public int deleteByPrimaryKey(String messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }

    //添加消息
    @Override
    public int insert(String messageContent,String messageTitle,String messageUserId) {
        Message record=new Message();
        String id= UUID.randomUUID().toString().replaceAll("-","");
        record.setMessageId(id);
        record.setMessageStatus(0);
        record.setMessageTime(new Date());
        record.setMessageContent(messageContent);
        record.setMessageTitle(messageTitle);
        record.setMessageUserId(messageUserId);
        return messageMapper.insert(record);
    }

    @Override
    public List queryAllByUserId(String messageUserId) {
        return messageMapper.queryAllByUserId(messageUserId);
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
    //查询未读信息数量
    @Override
    public int queryMessageNum(String userId) {
        int num=messageMapper.queryMessageNum(userId);
        return num;
    }
}