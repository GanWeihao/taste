package com.project.taste.model;

import java.util.Date;

public class Message {
    private String messageId;

    private String messageTitle;

    private String messageContent;

    private Date messageTime;

    private String messageUserId;

    private Integer messageStatus;

    public Message(String messageId, String messageTitle, String messageContent, Date messageTime, String messageUserId, Integer messageStatus) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageTime = messageTime;
        this.messageUserId = messageUserId;
        this.messageStatus = messageStatus;
    }

    public Message() {
        super();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(String messageUserId) {
        this.messageUserId = messageUserId == null ? null : messageUserId.trim();
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

}