package com.project.taste.bo;

import com.project.taste.model.User;

import java.util.Date;

public class ArticleComment_User {
    private String articleCommentId;

    private String articleCommentText;

    private Date articleCommentTime;

    private String articleCommentUserId;

    private String articleCommentArticleId;

    private String articleCommentTouserId;

    private Integer articleCommentStatus;

    private User user;

    private User toUser;

    public ArticleComment_User(String articleCommentId, String articleCommentText, Date articleCommentTime, String articleCommentUserId, String articleCommentArticleId, String articleCommentTouserId, Integer articleCommentStatus, User user, User toUser) {
        this.articleCommentId = articleCommentId;
        this.articleCommentText = articleCommentText;
        this.articleCommentTime = articleCommentTime;
        this.articleCommentUserId = articleCommentUserId;
        this.articleCommentArticleId = articleCommentArticleId;
        this.articleCommentTouserId = articleCommentTouserId;
        this.articleCommentStatus = articleCommentStatus;
        this.user = user;
        this.toUser = toUser;
    }

    public ArticleComment_User() {
        super();
    }

    public String getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(String articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public String getArticleCommentText() {
        return articleCommentText;
    }

    public void setArticleCommentText(String articleCommentText) {
        this.articleCommentText = articleCommentText;
    }

    public Date getArticleCommentTime() {
        return articleCommentTime;
    }

    public void setArticleCommentTime(Date articleCommentTime) {
        this.articleCommentTime = articleCommentTime;
    }

    public String getArticleCommentUserId() {
        return articleCommentUserId;
    }

    public void setArticleCommentUserId(String articleCommentUserId) {
        this.articleCommentUserId = articleCommentUserId;
    }

    public String getArticleCommentArticleId() {
        return articleCommentArticleId;
    }

    public void setArticleCommentArticleId(String articleCommentArticleId) {
        this.articleCommentArticleId = articleCommentArticleId;
    }

    public String getArticleCommentTouserId() {
        return articleCommentTouserId;
    }

    public void setArticleCommentTouserId(String articleCommentTouserId) {
        this.articleCommentTouserId = articleCommentTouserId;
    }

    public Integer getArticleCommentStatus() {
        return articleCommentStatus;
    }

    public void setArticleCommentStatus(Integer articleCommentStatus) {
        this.articleCommentStatus = articleCommentStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

}
